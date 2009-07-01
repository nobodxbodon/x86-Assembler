package org.p79068.assembler.generator;

import org.p79068.assembler.operand.ImmediateValue;
import org.p79068.assembler.operand.Memory32;
import org.p79068.assembler.operand.Operand;
import org.p79068.assembler.operand.Register;
import org.p79068.assembler.operand.Register32;


final class CodeGenerator {
	
	public static int getMachineCodeLength(InstructionPatternTable table, String mnemonic, Operand[] operands) {
		InstructionPattern patt = table.match(mnemonic, operands);
		int length = 0;
		
		if (patt.operandSizeMode == OperandSizeMode.MODE16)
			length++;
		
		length += patt.opcodes.length;
		
		if (patt.options.length == 1 && patt.options[0] instanceof ModRM)
			length += getModRMBytesLength((ModRM)patt.options[0], operands);
		
		for (int i = 0; i < patt.operands.length; i++) {
			OperandPattern slot = patt.operands[i];
			if (slot == OperandPattern.IMM8)
				length += 1;
			else if (slot == OperandPattern.IMM16)
				length += 2;
			else if (slot == OperandPattern.IMM32)
				length += 4;
		}
		
		return length;
	}
	
	
	private static int getModRMBytesLength(ModRM option, Operand[] operands) {
		Operand rm = operands[option.rmParameterIndex];
		
		if (rm instanceof Register) {
			return 1;
			
		} else if (rm instanceof Memory32) {
			Memory32 m = (Memory32)rm;
			ImmediateValue disp = ((ImmediateValue)m.getDisplacement());
			
			if (m.getBase() == null && m.getIndex() == null)  // disp32
				return 5;
			else if (m.getBase() != Register32.ESP_REGISTER && m.getBase() != Register32.EBP_REGISTER && m.getIndex() == null && disp.isZero())  // eax, ecx, edx, ebx, esi, edi
				return 1;
			else if (m.getBase() != Register32.ESP_REGISTER && m.getIndex() == null && disp.isSigned8Bit())  // (eax, ecx, edx, ebx, ebp, esi, edi) + disp8
				return 2;
			else if (m.getBase() != Register32.ESP_REGISTER && m.getIndex() == null)  // (eax, ecx, edx, ebx, ebp, esi, edi) + disp32
				return 5;
			else {  // SIB
				if (m.getBase() == null)  // index*scale + disp32
					return 6;
				else if (m.getBase() != Register32.EBP_REGISTER && disp.isZero())  // (eax, ecx, edx, ebx, esp, esi, edi) + index*scale
					return 2;
				else if (disp.isSigned8Bit())  // base + index*scale + disp8
					return 3;
				else  // base + index*scale + disp32
					return 6;
			}
			
		} else
			throw new AssertionError();
	}
	
	
	public static byte[] getMachineCode(InstructionPatternTable table, String mnemonic, Operand[] operands) {
		// Get matching instruction pattern
		InstructionPattern patt = table.match(mnemonic, operands);
		
		// Initialize blank result
		byte[] result = new byte[0];
		
		// Append operand size override prefix if necessary
		if (patt.operandSizeMode == OperandSizeMode.MODE16)
			result = concatenate(result, new byte[]{0x66});
		
		// Process register-in-opcode option
		byte[] opcodes = patt.opcodes;
		if (patt.options.length == 1 && patt.options[0] instanceof RegisterInOpcode) {
			RegisterInOpcode option = (RegisterInOpcode)patt.options[0];
			opcodes = opcodes.clone();
			opcodes[opcodes.length - 1] += ((Register)operands[option.parameterIndex]).getRegisterNumber();
		}
		
		// Append opcode
		result = concatenate(result, opcodes);
		
		// Append ModR/M and SIB bytes if necessary
		if (patt.options.length == 1 && patt.options[0] instanceof ModRM)
			result = concatenate(result, makeModRMBytes((ModRM)patt.options[0], operands));
		
		// Append immediate operands if necessary
		for (int i = 0; i < patt.operands.length; i++) {
			OperandPattern slot = patt.operands[i];
			if (slot == OperandPattern.IMM8) {
				int value = ((ImmediateValue)operands[i]).getValue();
				result = concatenate(result, new byte[]{(byte)(value >>> 0)});
			} else if (slot == OperandPattern.IMM16) {
				int value = ((ImmediateValue)operands[i]).getValue();
				result = concatenate(result, new byte[]{(byte)(value >>> 0), (byte)(value >>> 8)});
			} else if (slot == OperandPattern.IMM32) {
				int value = ((ImmediateValue)operands[i]).getValue();
				result = concatenate(result, new byte[]{(byte)(value >>> 0), (byte)(value >>> 8), (byte)(value >>> 16), (byte)(value >>> 24)});
			}
		}
		
		// Return machine code sequence
		return result;
	}
	
	
	private static byte[] makeModRMBytes(ModRM option, Operand[] operands) {
		Operand rm = operands[option.rmParameterIndex];
		int mod;
		int rmvalue;
		byte[] rest;
		
		if (rm instanceof Register) {
			mod = 3;
			rmvalue = ((Register)rm).getRegisterNumber();
			rest = new byte[0];
			
		} else if (rm instanceof Memory32) {
			Memory32 m = (Memory32)rm;
			ImmediateValue disp = ((ImmediateValue)m.getDisplacement());
			
			if (m.getBase() == null && m.getIndex() == null) {  // disp32
				mod = 0;
				rmvalue = 5;
				rest = disp.to4Bytes();
				
			} else if (m.getBase() != Register32.ESP_REGISTER && m.getBase() != Register32.EBP_REGISTER && m.getIndex() == null && disp.isZero()) {  // eax, ecx, edx, ebx, esi, edi
				mod = 0;
				rmvalue = m.getBase().getRegisterNumber();
				rest = new byte[0];
				
			} else if (m.getBase() != Register32.ESP_REGISTER && m.getIndex() == null && disp.isSigned8Bit()) {  // (eax, ecx, edx, ebx, ebp, esi, edi) + disp8
				mod = 1;
				rmvalue = m.getBase().getRegisterNumber();
				rest = disp.to1Byte();
				
			} else if (m.getBase() != Register32.ESP_REGISTER && m.getIndex() == null) {  // (eax, ecx, edx, ebx, ebp, esi, edi) + disp32
				mod = 2;
				rmvalue = m.getBase().getRegisterNumber();
				rest = disp.to4Bytes();
				
			} else {  // SIB
				rmvalue = 4;
				
				if (m.getBase() == null) {  // index*scale + disp32
					mod = 0;
					rest = disp.to4Bytes();
					
				} else if (m.getBase() != Register32.EBP_REGISTER && disp.isZero()) {  // (eax, ecx, edx, ebx, esp, esi, edi) + index*scale
					mod = 0;
					rest = new byte[0];
					
				} else if (disp.isSigned8Bit()) {  // base + index*scale + disp8
					mod = 1;
					rest = disp.to1Byte();
					
				} else {  // base + index*scale + disp32
					mod = 2;
					rest = disp.to4Bytes();
				}
				
				byte[] sib = makeSIBByte(m);
				rest = concatenate(sib, rest);
			}
			
		} else
			throw new AssertionError();
		
		// Set reg/op value
		int regopvalue;
		if (option.regOpcodeParameterIndex < 10) {
			Register regop = (Register)operands[option.regOpcodeParameterIndex];
			regopvalue = regop.getRegisterNumber();
		} else
			regopvalue = option.regOpcodeParameterIndex - 10;
		
		// Make ModR/M byte
		byte[] modrm = makeModRMByte(mod, regopvalue, rmvalue);
		
		// Concatenate and return
		return concatenate(modrm, rest);
	}
	
	
	private static byte[] makeModRMByte(int mod, int regop, int rm) {
		if (mod < 0 || mod >= 4 || regop < 0 || regop >= 8 || rm < 0 || rm >= 8)
			throw new IllegalArgumentException();
		return new byte[]{(byte)(mod << 6 | regop << 3 | rm << 0)};
	}
	
	
	private static byte[] makeSIBByte(Memory32 mem) {
		int scale = getScaleNumber(mem.getScale());
		int index = getIndexNumber(mem.getIndex());
		int base = getBaseNumber(mem.getBase());
		return new byte[]{(byte)(scale << 6 | index << 3 | base << 0)};
	}
	
	
	private static int getBaseNumber(Register32 base) {
		if (base != null)
			return base.getRegisterNumber();
		else
			return 5;
	}
	
	
	private static int getIndexNumber(Register32 index) {
		if (index == Register32.ESP_REGISTER)
			throw new IllegalArgumentException();
		if (index != null)
			return index.getRegisterNumber();
		else
			return 4;
	}
	
	
	private static int getScaleNumber(int scale) {
		switch (scale) {
			case 1:  return 0;
			case 2:  return 1;
			case 4:  return 2;
			case 8:  return 3;
			default:  throw new AssertionError();
		}
	}
	
	
	private static byte[] concatenate(byte[]... arrays) {
		int totalLength = 0;
		for (byte[] b : arrays)
			totalLength += b.length;
		
		byte[] result = new byte[totalLength];
		int offset = 0;
		for (byte[] b : arrays) {
			System.arraycopy(b, 0, result, offset, b.length);
			offset += b.length;
		}
		return result;
	}
	
	
	
	/**
	 * Not instantiable.
	 */
	private CodeGenerator() {}
	
}
