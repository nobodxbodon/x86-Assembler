package org.p79068.assembler.generator;

import static org.p79068.assembler.generator.OperandPattern.*;
import static org.p79068.assembler.generator.OperandSizeMode.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.p79068.assembler.operand.Operand;


public class InstructionPatternTable {
	
	public static final InstructionPatternTable MODE32_TABLE;
	
	static {
		MODE32_TABLE = new InstructionPatternTable();
		MODE32_TABLE.add(new InstructionPattern("addb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x00}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("addw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x01}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("addl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x01}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("addb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x02}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("addw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x03}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("addl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x03}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("addb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x04}));
		MODE32_TABLE.add(new InstructionPattern("addw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x05}));
		MODE32_TABLE.add(new InstructionPattern("addl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x05}));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{ES}                  , MODELESS, new int[]{0x06}));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{ES}                  , MODELESS, new int[]{0x07}));
		MODE32_TABLE.add(new InstructionPattern("orb"      , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x08}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("orw"      , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x09}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("orl"      , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x09}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("orb"      , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x0A}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("orw"      , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("orl"      , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x0B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("orb"      , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x0C}));
		MODE32_TABLE.add(new InstructionPattern("orw"      , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x0D}));
		MODE32_TABLE.add(new InstructionPattern("orl"      , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x0D}));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{CS}                  , MODELESS, new int[]{0x0E}));
		MODE32_TABLE.add(new InstructionPattern("adcb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x10}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("adcw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x11}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("adcl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x11}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("adcb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x12}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("adcw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x13}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("adcl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x13}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("adcb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x14}));
		MODE32_TABLE.add(new InstructionPattern("adcw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x15}));
		MODE32_TABLE.add(new InstructionPattern("adcl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x15}));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{SS}                  , MODELESS, new int[]{0x16}));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{SS}                  , MODELESS, new int[]{0x17}));
		MODE32_TABLE.add(new InstructionPattern("sbbb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x18}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("sbbw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x19}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("sbbl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x19}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("sbbb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x1A}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("sbbw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x1B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("sbbl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x1B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("sbbb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x1C}));
		MODE32_TABLE.add(new InstructionPattern("sbbw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x1D}));
		MODE32_TABLE.add(new InstructionPattern("sbbl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x1D}));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{DS}                  , MODELESS, new int[]{0x1E}));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{DS}                  , MODELESS, new int[]{0x1F}));
		MODE32_TABLE.add(new InstructionPattern("andb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x20}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("andw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x21}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("andl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x21}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("andb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x22}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("andw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x23}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("andl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x23}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("andb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x24}));
		MODE32_TABLE.add(new InstructionPattern("andw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x25}));
		MODE32_TABLE.add(new InstructionPattern("andl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x25}));
		MODE32_TABLE.add(new InstructionPattern("daa"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x27}));
		MODE32_TABLE.add(new InstructionPattern("subb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x28}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("subw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x29}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("subl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x29}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("subb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x2A}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("subw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x2B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("subl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x2B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("subb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x2C}));
		MODE32_TABLE.add(new InstructionPattern("subw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x2D}));
		MODE32_TABLE.add(new InstructionPattern("subl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x2D}));
		MODE32_TABLE.add(new InstructionPattern("das"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x2F}));
		MODE32_TABLE.add(new InstructionPattern("xorb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x30}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xorw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x31}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xorl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x31}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xorb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x32}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("xorw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x33}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("xorl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x33}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("xorb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x34}));
		MODE32_TABLE.add(new InstructionPattern("xorw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x35}));
		MODE32_TABLE.add(new InstructionPattern("xorl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x35}));
		MODE32_TABLE.add(new InstructionPattern("aaa"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x37}));
		MODE32_TABLE.add(new InstructionPattern("cmpb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x38}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x39}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x39}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x3A}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("cmpw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x3B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("cmpl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x3B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("cmpb"     , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0x3C}));
		MODE32_TABLE.add(new InstructionPattern("cmpw"     , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0x3D}));
		MODE32_TABLE.add(new InstructionPattern("cmpl"     , new OperandPattern[]{EAX, IMM32}          , MODE32  , new int[]{0x3D}));
		MODE32_TABLE.add(new InstructionPattern("aas"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x3F}));
		MODE32_TABLE.add(new InstructionPattern("incw"     , new OperandPattern[]{REG16}               , MODE16  , new int[]{0x40}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("incl"     , new OperandPattern[]{REG32}               , MODE32  , new int[]{0x40}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("decw"     , new OperandPattern[]{REG16}               , MODE16  , new int[]{0x48}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("decl"     , new OperandPattern[]{REG32}               , MODE32  , new int[]{0x48}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{REG16}               , MODE16  , new int[]{0x50}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("pushl"    , new OperandPattern[]{REG32}               , MODE32  , new int[]{0x50}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{REG16}               , MODE16  , new int[]{0x58}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("popl"     , new OperandPattern[]{REG32}               , MODE32  , new int[]{0x58}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("pushaw"   , new OperandPattern[]{}                    , MODE16  , new int[]{0x60}));
		MODE32_TABLE.add(new InstructionPattern("pushal"   , new OperandPattern[]{}                    , MODE32  , new int[]{0x60}));
		MODE32_TABLE.add(new InstructionPattern("popaw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0x61}));
		MODE32_TABLE.add(new InstructionPattern("popal"    , new OperandPattern[]{}                    , MODE32  , new int[]{0x61}));
		MODE32_TABLE.add(new InstructionPattern("boundw"   , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0x62}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("boundl"   , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0x62}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("arpl"     , new OperandPattern[]{RM16, REG16}         , MODELESS, new int[]{0x63}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{IMM16}               , MODE16  , new int[]{0x68}));
		MODE32_TABLE.add(new InstructionPattern("pushl"    , new OperandPattern[]{IMM32}               , MODE32  , new int[]{0x68}));
		MODE32_TABLE.add(new InstructionPattern("imulw"    , new OperandPattern[]{REG16, RM16, IMM16}  , MODE16  , new int[]{0x69}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("imull"    , new OperandPattern[]{REG32, RM32, IMM32}  , MODE32  , new int[]{0x69}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("pushb"    , new OperandPattern[]{IMM8}                , MODELESS, new int[]{0x6A}));
		MODE32_TABLE.add(new InstructionPattern("imulwb"   , new OperandPattern[]{REG16, RM16, IMM8}   , MODE16  , new int[]{0x6B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("imullb"   , new OperandPattern[]{REG32, RM32, IMM8}   , MODE32  , new int[]{0x6B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("insb"     , new OperandPattern[]{}                    , MODELESS, new int[]{0x6C}));
		MODE32_TABLE.add(new InstructionPattern("insw"     , new OperandPattern[]{}                    , MODE16  , new int[]{0x6D}));
		MODE32_TABLE.add(new InstructionPattern("insl"     , new OperandPattern[]{}                    , MODE32  , new int[]{0x6D}));
		MODE32_TABLE.add(new InstructionPattern("outsb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0x6E}));
		MODE32_TABLE.add(new InstructionPattern("outsw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0x6F}));
		MODE32_TABLE.add(new InstructionPattern("outsl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0x6F}));
		MODE32_TABLE.add(new InstructionPattern("jo"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x70}));
		MODE32_TABLE.add(new InstructionPattern("jno"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x71}));
		MODE32_TABLE.add(new InstructionPattern("jb"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x72}));
		MODE32_TABLE.add(new InstructionPattern("jnae"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x72}));
		MODE32_TABLE.add(new InstructionPattern("jc"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x72}));
		MODE32_TABLE.add(new InstructionPattern("jnb"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x73}));
		MODE32_TABLE.add(new InstructionPattern("jae"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x73}));
		MODE32_TABLE.add(new InstructionPattern("jnc"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x73}));
		MODE32_TABLE.add(new InstructionPattern("jz"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x74}));
		MODE32_TABLE.add(new InstructionPattern("je"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x74}));
		MODE32_TABLE.add(new InstructionPattern("jnz"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x75}));
		MODE32_TABLE.add(new InstructionPattern("jne"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x75}));
		MODE32_TABLE.add(new InstructionPattern("jbe"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x76}));
		MODE32_TABLE.add(new InstructionPattern("jna"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x76}));
		MODE32_TABLE.add(new InstructionPattern("jnbe"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x77}));
		MODE32_TABLE.add(new InstructionPattern("ja"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x77}));
		MODE32_TABLE.add(new InstructionPattern("js"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x78}));
		MODE32_TABLE.add(new InstructionPattern("jns"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x79}));
		MODE32_TABLE.add(new InstructionPattern("jp"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7A}));
		MODE32_TABLE.add(new InstructionPattern("jpe"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7A}));
		MODE32_TABLE.add(new InstructionPattern("jnp"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7B}));
		MODE32_TABLE.add(new InstructionPattern("jnpo"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7B}));
		MODE32_TABLE.add(new InstructionPattern("jl"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7C}));
		MODE32_TABLE.add(new InstructionPattern("jnge"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7C}));
		MODE32_TABLE.add(new InstructionPattern("jnl"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7D}));
		MODE32_TABLE.add(new InstructionPattern("jge"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7D}));
		MODE32_TABLE.add(new InstructionPattern("jle"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7E}));
		MODE32_TABLE.add(new InstructionPattern("jng"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7E}));
		MODE32_TABLE.add(new InstructionPattern("jnle"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7F}));
		MODE32_TABLE.add(new InstructionPattern("jg"       , new OperandPattern[]{REL8}                , MODELESS, new int[]{0x7F}));
		MODE32_TABLE.add(new InstructionPattern("addb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("orb"      , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("adcb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("sbbb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("andb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("subb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("xorb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("cmpb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0x80}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("addw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("orw"      , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("adcw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("sbbw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("andw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("subw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("xorw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("cmpw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0x81}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("addl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("orl"      , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("adcl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("sbbl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("andl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("subl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("xorl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("cmpl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0x81}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("addwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("orwb"     , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("adcwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("sbbwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("andwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("subwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("xorwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("cmpwb"    , new OperandPattern[]{RM16, IMM8S}         , MODE16  , new int[]{0x83}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("addlb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("orlb"     , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("adclb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("sbblb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("andlb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("sublb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("xorlb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("cmplb"    , new OperandPattern[]{RM32, IMM8S}         , MODE32  , new int[]{0x83}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("testb"    , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x84}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("testw"    , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x85}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("testl"    , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x85}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xchgb"    , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x86}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xchgw"    , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x87}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xchgl"    , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x87}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("movb"     , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x88}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x89}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("movl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x89}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("movb"     , new OperandPattern[]{REG8, RM8}           , MODELESS, new int[]{0x8A}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x8B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x8B}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{RM16, SREG}          , MODE16  , new int[]{0x8C}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("movlw"    , new OperandPattern[]{RM32, SREG}          , MODE32  , new int[]{0x8C}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("leaw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0x8D}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("leal"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0x8D}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{SREG, RM16}          , MODE16  , new int[]{0x8E}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movwl"    , new OperandPattern[]{SREG, RM32}          , MODE32  , new int[]{0x8E}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0x8F}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("popl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0x8F}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("nop"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x90}));
		MODE32_TABLE.add(new InstructionPattern("xchgw"    , new OperandPattern[]{REG16, AX}           , MODE16  , new int[]{0x90}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("xchgl"    , new OperandPattern[]{REG32, EAX}          , MODE32  , new int[]{0x90}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("cbw"      , new OperandPattern[]{}                    , MODE16  , new int[]{0x98}));
		MODE32_TABLE.add(new InstructionPattern("cwde"     , new OperandPattern[]{}                    , MODE32  , new int[]{0x98}));
		MODE32_TABLE.add(new InstructionPattern("cwd"      , new OperandPattern[]{}                    , MODE16  , new int[]{0x99}));
		MODE32_TABLE.add(new InstructionPattern("cdq"      , new OperandPattern[]{}                    , MODE32  , new int[]{0x99}));
		MODE32_TABLE.add(new InstructionPattern("pushfw"   , new OperandPattern[]{}                    , MODE16  , new int[]{0x9C}));
		MODE32_TABLE.add(new InstructionPattern("pushfl"   , new OperandPattern[]{}                    , MODE32  , new int[]{0x9C}));
		MODE32_TABLE.add(new InstructionPattern("popfw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0x9D}));
		MODE32_TABLE.add(new InstructionPattern("popfl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0x9D}));
		MODE32_TABLE.add(new InstructionPattern("sahf"     , new OperandPattern[]{}                    , MODELESS, new int[]{0x9E}));
		MODE32_TABLE.add(new InstructionPattern("lahf"     , new OperandPattern[]{}                    , MODELESS, new int[]{0x9F}));
		MODE32_TABLE.add(new InstructionPattern("movsb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xA4}));
		MODE32_TABLE.add(new InstructionPattern("movsw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xA5}));
		MODE32_TABLE.add(new InstructionPattern("movsl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xA5}));
		MODE32_TABLE.add(new InstructionPattern("cmpsb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xA6}));
		MODE32_TABLE.add(new InstructionPattern("cmpsw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xA7}));
		MODE32_TABLE.add(new InstructionPattern("cmpsl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xA8}));
		MODE32_TABLE.add(new InstructionPattern("testb"    , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0xA8}));
		MODE32_TABLE.add(new InstructionPattern("testw"    , new OperandPattern[]{AX, IMM16}           , MODE16  , new int[]{0xA9}));
		MODE32_TABLE.add(new InstructionPattern("testl"    , new OperandPattern[]{AX, IMM32}           , MODE32  , new int[]{0xA9}));
		MODE32_TABLE.add(new InstructionPattern("stosb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xAA}));
		MODE32_TABLE.add(new InstructionPattern("stosw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xAB}));
		MODE32_TABLE.add(new InstructionPattern("stosl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xAB}));
		MODE32_TABLE.add(new InstructionPattern("lodsb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xAC}));
		MODE32_TABLE.add(new InstructionPattern("lodsw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xAD}));
		MODE32_TABLE.add(new InstructionPattern("lodsl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xAD}));
		MODE32_TABLE.add(new InstructionPattern("scasb"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xAE}));
		MODE32_TABLE.add(new InstructionPattern("scasw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xAF}));
		MODE32_TABLE.add(new InstructionPattern("scasl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xAF}));
		MODE32_TABLE.add(new InstructionPattern("movb"     , new OperandPattern[]{REG8, IMM8}          , MODELESS, new int[]{0xB0}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{REG16, IMM16}        , MODE16  , new int[]{0xB8}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("movl"     , new OperandPattern[]{REG32, IMM32}        , MODE32  , new int[]{0xB8}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("rolb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC0}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("rolw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0xC1}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("roll"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rcll"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shll"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("sall"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0xC1}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("ret"      , new OperandPattern[]{IMM16}               , MODELESS, new int[]{0xC2}));
		MODE32_TABLE.add(new InstructionPattern("ret"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xC3}));
		MODE32_TABLE.add(new InstructionPattern("lesw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0xC4}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("lesl"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0xC4}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("ldsw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0xC5}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("ldsl"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0xC5}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movb"     , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xC6}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("movw"     , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0xC7}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("movl"     , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0xC7}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("enter"    , new OperandPattern[]{IMM16, IMM8}         , MODELESS, new int[]{0xC8}));
		MODE32_TABLE.add(new InstructionPattern("leave"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xC9}));
		MODE32_TABLE.add(new InstructionPattern("lret"     , new OperandPattern[]{IMM16}               , MODELESS, new int[]{0xCA}));
		MODE32_TABLE.add(new InstructionPattern("lret"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xCB}));
		MODE32_TABLE.add(new InstructionPattern("int"      , new OperandPattern[]{IMM_VAL_3}           , MODELESS, new int[]{0xCC}));
		MODE32_TABLE.add(new InstructionPattern("int"      , new OperandPattern[]{IMM8}                , MODELESS, new int[]{0xCD}));
		MODE32_TABLE.add(new InstructionPattern("into"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xCE}));
		MODE32_TABLE.add(new InstructionPattern("iretw"    , new OperandPattern[]{}                    , MODE16  , new int[]{0xCF}));
		MODE32_TABLE.add(new InstructionPattern("iretl"    , new OperandPattern[]{}                    , MODE32  , new int[]{0xCF}));
		MODE32_TABLE.add(new InstructionPattern("rolb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarb"     , new OperandPattern[]{RM8, IMM_VAL_1}      , MODELESS, new int[]{0xD0}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("rolw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarw"     , new OperandPattern[]{RM16, IMM_VAL_1}     , MODE16  , new int[]{0xD1}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("roll"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorl"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rcll"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrl"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shll"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("sall"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrl"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarl"     , new OperandPattern[]{RM32, IMM_VAL_1}     , MODE32  , new int[]{0xD1}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("rolb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarb"     , new OperandPattern[]{RM8, CL}             , MODELESS, new int[]{0xD2}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("rolw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rclw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shlw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("salw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarw"     , new OperandPattern[]{RM16, CL}            , MODE16  , new int[]{0xD3}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("roll"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("rorl"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("rcll"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("rcrl"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("shll"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("sall"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("shrl"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("sarl"     , new OperandPattern[]{RM32, CL}            , MODE32  , new int[]{0xD3}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("aam"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xD4, 0x0A}));
		MODE32_TABLE.add(new InstructionPattern("aad"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xD5, 0x0A}));
		MODE32_TABLE.add(new InstructionPattern("salc"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xD6}));
		MODE32_TABLE.add(new InstructionPattern("setalc"   , new OperandPattern[]{}                    , MODELESS, new int[]{0xD6}));
		MODE32_TABLE.add(new InstructionPattern("xlat"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xD7}));
		MODE32_TABLE.add(new InstructionPattern("loopnz"   , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE0}));
		MODE32_TABLE.add(new InstructionPattern("loopne"   , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE0}));
		MODE32_TABLE.add(new InstructionPattern("loopz"    , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE1}));
		MODE32_TABLE.add(new InstructionPattern("loope"    , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE1}));
		MODE32_TABLE.add(new InstructionPattern("loop"     , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE2}));
		MODE32_TABLE.add(new InstructionPattern("jecxz"    , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xE3}));
		MODE32_TABLE.add(new InstructionPattern("inb"      , new OperandPattern[]{AL, IMM8}            , MODELESS, new int[]{0xE4}));
		MODE32_TABLE.add(new InstructionPattern("inw"      , new OperandPattern[]{AX, IMM8}            , MODE16  , new int[]{0xE5}));
		MODE32_TABLE.add(new InstructionPattern("inl"      , new OperandPattern[]{EAX, IMM8}           , MODE32  , new int[]{0xE5}));
		MODE32_TABLE.add(new InstructionPattern("outb"     , new OperandPattern[]{IMM8, AL}            , MODELESS, new int[]{0xE6}));
		MODE32_TABLE.add(new InstructionPattern("outw"     , new OperandPattern[]{IMM8, AX}            , MODE16  , new int[]{0xE7}));
		MODE32_TABLE.add(new InstructionPattern("outl"     , new OperandPattern[]{IMM8, EAX}           , MODE32  , new int[]{0xE7}));
		MODE32_TABLE.add(new InstructionPattern("call"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0xE8}));
		MODE32_TABLE.add(new InstructionPattern("call"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0xE8}));
		MODE32_TABLE.add(new InstructionPattern("jmp"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0xE9}));
		MODE32_TABLE.add(new InstructionPattern("jmp"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0xE9}));
		MODE32_TABLE.add(new InstructionPattern("ljmpw"    , new OperandPattern[]{MEM}                 , MODE16  , new int[]{0xE9}));
		MODE32_TABLE.add(new InstructionPattern("ljmpl"    , new OperandPattern[]{MEM}                 , MODE32  , new int[]{0xE9}));
		MODE32_TABLE.add(new InstructionPattern("jmp"      , new OperandPattern[]{REL8}                , MODELESS, new int[]{0xEB}));
		MODE32_TABLE.add(new InstructionPattern("inb"      , new OperandPattern[]{AL, DX}              , MODELESS, new int[]{0xEC}));
		MODE32_TABLE.add(new InstructionPattern("inw"      , new OperandPattern[]{AX, DX}              , MODE16  , new int[]{0xED}));
		MODE32_TABLE.add(new InstructionPattern("inl"      , new OperandPattern[]{EAX, DX}             , MODE32  , new int[]{0xED}));
		MODE32_TABLE.add(new InstructionPattern("outb"     , new OperandPattern[]{DX, AL}              , MODELESS, new int[]{0xEE}));
		MODE32_TABLE.add(new InstructionPattern("outw"     , new OperandPattern[]{DX, AX}              , MODE16  , new int[]{0xEF}));
		MODE32_TABLE.add(new InstructionPattern("outl"     , new OperandPattern[]{DX, EAX}             , MODE32  , new int[]{0xEF}));
		MODE32_TABLE.add(new InstructionPattern("lock"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xF0}));
		MODE32_TABLE.add(new InstructionPattern("repne"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xF2}));
		MODE32_TABLE.add(new InstructionPattern("repnz"    , new OperandPattern[]{}                    , MODELESS, new int[]{0xF2}));
		MODE32_TABLE.add(new InstructionPattern("rep"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xF3}));
		MODE32_TABLE.add(new InstructionPattern("repe"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xF3}));
		MODE32_TABLE.add(new InstructionPattern("repz"     , new OperandPattern[]{}                    , MODELESS, new int[]{0xF3}));
		MODE32_TABLE.add(new InstructionPattern("hlt"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xF4}));
		MODE32_TABLE.add(new InstructionPattern("cmc"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xF5}));
		MODE32_TABLE.add(new InstructionPattern("testb"    , new OperandPattern[]{RM8, IMM8}           , MODELESS, new int[]{0xF6}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("notb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("negb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("mulb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("imulb"    , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("divb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("idivb"    , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xF6}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("testw"    , new OperandPattern[]{RM16, IMM16}         , MODE16  , new int[]{0xF7}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("notw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("negw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("mulw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("imulw"    , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("divw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("idivw"    , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xF7}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("testl"    , new OperandPattern[]{RM32, IMM32}         , MODE32  , new int[]{0xF7}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("notl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("negl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("mull"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("imull"    , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("divl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("idivl"    , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xF7}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("clc"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xF8}));
		MODE32_TABLE.add(new InstructionPattern("stc"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xF9}));
		MODE32_TABLE.add(new InstructionPattern("cli"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xFA}));
		MODE32_TABLE.add(new InstructionPattern("sti"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xFB}));
		MODE32_TABLE.add(new InstructionPattern("cld"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xFC}));
		MODE32_TABLE.add(new InstructionPattern("std"      , new OperandPattern[]{}                    , MODELESS, new int[]{0xFD}));
		MODE32_TABLE.add(new InstructionPattern("incb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xFE}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("decb"     , new OperandPattern[]{RM8}                 , MODELESS, new int[]{0xFE}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("incw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xFF}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("decw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xFF}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("callw"    , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xFF}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("lcallw"   , new OperandPattern[]{MEM}                 , MODE16  , new int[]{0xFF}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("jmpw"     , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xFF}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("ljmpw"    , new OperandPattern[]{MEM}                 , MODE16  , new int[]{0xFF}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{RM16}                , MODE16  , new int[]{0xFF}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("incl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xFF}, new ModRM(0, 10)));
		MODE32_TABLE.add(new InstructionPattern("decl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xFF}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("calll"    , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xFF}, new ModRM(0, 12)));
		MODE32_TABLE.add(new InstructionPattern("lcalll"   , new OperandPattern[]{MEM}                 , MODE32  , new int[]{0xFF}, new ModRM(0, 13)));
		MODE32_TABLE.add(new InstructionPattern("jmpl"     , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xFF}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("ljmpl"    , new OperandPattern[]{MEM}                 , MODE32  , new int[]{0xFF}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("pushl"    , new OperandPattern[]{RM32}                , MODE32  , new int[]{0xFF}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("invd"     , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0x08}));
		MODE32_TABLE.add(new InstructionPattern("wbinvd"   , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0x09}));
		MODE32_TABLE.add(new InstructionPattern("ud2"      , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0x0B}));
		MODE32_TABLE.add(new InstructionPattern("sysenter" , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0x34}));
		MODE32_TABLE.add(new InstructionPattern("sysexit"  , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0x35}));
		MODE32_TABLE.add(new InstructionPattern("jo"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x80}));
		MODE32_TABLE.add(new InstructionPattern("jno"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x81}));
		MODE32_TABLE.add(new InstructionPattern("jb"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jnae"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jc"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jnb"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jae"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jnc"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jz"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x84}));
		MODE32_TABLE.add(new InstructionPattern("je"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x84}));
		MODE32_TABLE.add(new InstructionPattern("jnz"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x85}));
		MODE32_TABLE.add(new InstructionPattern("jne"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x85}));
		MODE32_TABLE.add(new InstructionPattern("jbe"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x86}));
		MODE32_TABLE.add(new InstructionPattern("jna"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x86}));
		MODE32_TABLE.add(new InstructionPattern("jnbe"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x87}));
		MODE32_TABLE.add(new InstructionPattern("ja"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x87}));
		MODE32_TABLE.add(new InstructionPattern("js"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x88}));
		MODE32_TABLE.add(new InstructionPattern("jns"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x89}));
		MODE32_TABLE.add(new InstructionPattern("jp"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8A}));
		MODE32_TABLE.add(new InstructionPattern("jpe"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8A}));
		MODE32_TABLE.add(new InstructionPattern("jnp"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8B}));
		MODE32_TABLE.add(new InstructionPattern("jnpo"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8B}));
		MODE32_TABLE.add(new InstructionPattern("jl"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8C}));
		MODE32_TABLE.add(new InstructionPattern("jnge"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8C}));
		MODE32_TABLE.add(new InstructionPattern("jnl"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8D}));
		MODE32_TABLE.add(new InstructionPattern("jge"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8D}));
		MODE32_TABLE.add(new InstructionPattern("jle"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8E}));
		MODE32_TABLE.add(new InstructionPattern("jng"      , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8E}));
		MODE32_TABLE.add(new InstructionPattern("jnle"     , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8F}));
		MODE32_TABLE.add(new InstructionPattern("jg"       , new OperandPattern[]{REL16}               , MODE16  , new int[]{0x0F, 0x8F}));
		MODE32_TABLE.add(new InstructionPattern("jo"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x80}));
		MODE32_TABLE.add(new InstructionPattern("jno"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x81}));
		MODE32_TABLE.add(new InstructionPattern("jb"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jnae"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jc"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x82}));
		MODE32_TABLE.add(new InstructionPattern("jnb"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jae"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jnc"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x83}));
		MODE32_TABLE.add(new InstructionPattern("jz"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x84}));
		MODE32_TABLE.add(new InstructionPattern("je"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x84}));
		MODE32_TABLE.add(new InstructionPattern("jnz"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x85}));
		MODE32_TABLE.add(new InstructionPattern("jne"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x85}));
		MODE32_TABLE.add(new InstructionPattern("jbe"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x86}));
		MODE32_TABLE.add(new InstructionPattern("jna"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x86}));
		MODE32_TABLE.add(new InstructionPattern("jnbe"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x87}));
		MODE32_TABLE.add(new InstructionPattern("ja"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x87}));
		MODE32_TABLE.add(new InstructionPattern("js"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x88}));
		MODE32_TABLE.add(new InstructionPattern("jns"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x89}));
		MODE32_TABLE.add(new InstructionPattern("jp"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8A}));
		MODE32_TABLE.add(new InstructionPattern("jpe"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8A}));
		MODE32_TABLE.add(new InstructionPattern("jnp"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8B}));
		MODE32_TABLE.add(new InstructionPattern("jnpo"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8B}));
		MODE32_TABLE.add(new InstructionPattern("jl"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8C}));
		MODE32_TABLE.add(new InstructionPattern("jnge"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8C}));
		MODE32_TABLE.add(new InstructionPattern("jnl"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8D}));
		MODE32_TABLE.add(new InstructionPattern("jge"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8D}));
		MODE32_TABLE.add(new InstructionPattern("jle"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8E}));
		MODE32_TABLE.add(new InstructionPattern("jng"      , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8E}));
		MODE32_TABLE.add(new InstructionPattern("jnle"     , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8F}));
		MODE32_TABLE.add(new InstructionPattern("jg"       , new OperandPattern[]{REL32}               , MODE32  , new int[]{0x0F, 0x8F}));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{FS}                  , MODELESS, new int[]{0x0F, 0xA0}));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{FS}                  , MODELESS, new int[]{0x0F, 0xA1}));
		MODE32_TABLE.add(new InstructionPattern("cpuid"    , new OperandPattern[]{}                    , MODELESS, new int[]{0x0F, 0xA2}));
		MODE32_TABLE.add(new InstructionPattern("btw"      , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xA3}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("btl"      , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xA3}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shldw"    , new OperandPattern[]{RM16, REG16, IMM8}   , MODE16  , new int[]{0x0F, 0xA4}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shldl"    , new OperandPattern[]{RM32, REG32, IMM8}   , MODE32  , new int[]{0x0F, 0xA4}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shldw"    , new OperandPattern[]{RM16, REG16, CL}     , MODE16  , new int[]{0x0F, 0xA5}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shldl"    , new OperandPattern[]{RM32, REG32, CL}     , MODE32  , new int[]{0x0F, 0xA5}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("pushw"    , new OperandPattern[]{GS}                  , MODELESS, new int[]{0x0F, 0xA8}));
		MODE32_TABLE.add(new InstructionPattern("popw"     , new OperandPattern[]{GS}                  , MODELESS, new int[]{0x0F, 0xA9}));
		MODE32_TABLE.add(new InstructionPattern("btsw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xAB}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("btsl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xAB}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shrdw"    , new OperandPattern[]{RM16, REG16, IMM8}   , MODE16  , new int[]{0x0F, 0xAC}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shrdl"    , new OperandPattern[]{RM32, REG32, IMM8}   , MODE32  , new int[]{0x0F, 0xAC}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shrdw"    , new OperandPattern[]{RM16, REG16, CL}     , MODE16  , new int[]{0x0F, 0xAD}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("shrdl"    , new OperandPattern[]{RM32, REG32, CL}     , MODE32  , new int[]{0x0F, 0xAD}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("imulw"    , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0F, 0xAF}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("imull"    , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x0F, 0xAF}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("cmpxchgb" , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x0F, 0xB0}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpxchgw" , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xB1}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpxchgl" , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xB1}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("lssw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0x0F, 0xB2}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("lssl"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0x0F, 0xB2}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("btrw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xB3}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("btrl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xB3}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("lfsw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0x0F, 0xB4}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("lfsl"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0x0F, 0xB4}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("lgsw"     , new OperandPattern[]{REG16, MEM}          , MODE16  , new int[]{0x0F, 0xB5}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("lgsl"     , new OperandPattern[]{REG32, MEM}          , MODE32  , new int[]{0x0F, 0xB5}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movzxwb"  , new OperandPattern[]{REG16, RM8}          , MODE16  , new int[]{0x0F, 0xB6}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movzxlb"  , new OperandPattern[]{REG32, RM8}          , MODE32  , new int[]{0x0F, 0xB6}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movzxww"  , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0F, 0xB7}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movzxlw"  , new OperandPattern[]{REG32, RM16}         , MODE32  , new int[]{0x0F, 0xB7}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("btw"      , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0x0F, 0xBA}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("btl"      , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0x0F, 0xBA}, new ModRM(0, 14)));
		MODE32_TABLE.add(new InstructionPattern("btsw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0x0F, 0xBA}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("btsl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0x0F, 0xBA}, new ModRM(0, 15)));
		MODE32_TABLE.add(new InstructionPattern("btrw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0x0F, 0xBA}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("btrl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0x0F, 0xBA}, new ModRM(0, 16)));
		MODE32_TABLE.add(new InstructionPattern("btcw"     , new OperandPattern[]{RM16, IMM8}          , MODE16  , new int[]{0x0F, 0xBA}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("btcl"     , new OperandPattern[]{RM32, IMM8}          , MODE32  , new int[]{0x0F, 0xBA}, new ModRM(0, 17)));
		MODE32_TABLE.add(new InstructionPattern("btcw"     , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xBB}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("btcl"     , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xBB}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("bsfw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0F, 0xBC}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("bsfl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x0F, 0xBC}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("bsrw"     , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0F, 0xBD}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("bsrl"     , new OperandPattern[]{REG32, RM32}         , MODE32  , new int[]{0x0F, 0xBD}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movsxwb"  , new OperandPattern[]{REG16, RM8}          , MODE16  , new int[]{0x0F, 0xBE}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movsxlb"  , new OperandPattern[]{REG32, RM8}          , MODE32  , new int[]{0x0F, 0xBE}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movsxww"  , new OperandPattern[]{REG16, RM16}         , MODE16  , new int[]{0x0F, 0xBF}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("movsxlw"  , new OperandPattern[]{REG32, RM16}         , MODE32  , new int[]{0x0F, 0xBF}, new ModRM(1, 0)));
		MODE32_TABLE.add(new InstructionPattern("xaddb"    , new OperandPattern[]{RM8, REG8}           , MODELESS, new int[]{0x0F, 0xC0}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xaddw"    , new OperandPattern[]{RM16, REG16}         , MODE16  , new int[]{0x0F, 0xC1}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("xaddl"    , new OperandPattern[]{RM32, REG32}         , MODE32  , new int[]{0x0F, 0xC1}, new ModRM(0, 1)));
		MODE32_TABLE.add(new InstructionPattern("cmpxchg8b", new OperandPattern[]{MEM}                 , MODELESS, new int[]{0x0F, 0xC7}, new ModRM(0, 11)));
		MODE32_TABLE.add(new InstructionPattern("bswapw"   , new OperandPattern[]{REG16}               , MODE16  , new int[]{0x0F, 0xC8}, new RegisterInOpcode(0)));
		MODE32_TABLE.add(new InstructionPattern("bswapl"   , new OperandPattern[]{REG32}               , MODE32  , new int[]{0x0F, 0xC8}, new RegisterInOpcode(0)));
	}
	
	
	
	private Set<InstructionPattern> patterns;
	
	private Map<String,Set<InstructionPattern>> patternsByMnemonic;
	
	
	
	private InstructionPatternTable() {
		patterns = new HashSet<InstructionPattern>();
		patternsByMnemonic = new HashMap<String,Set<InstructionPattern>>();
	}
	
	
	
	private void add(InstructionPattern pat) {
		patterns.add(pat);
		
		if (!patternsByMnemonic.containsKey(pat.mnemonic))
			patternsByMnemonic.put(pat.mnemonic, new HashSet<InstructionPattern>());
		patternsByMnemonic.get(pat.mnemonic).add(pat);
	}
	
	
	public InstructionPattern match(String mnemonic, Operand[] operands) {
		if (!patternsByMnemonic.containsKey(mnemonic))
			throw new IllegalArgumentException("Invalid mnemonic: " + mnemonic);
		
		InstructionPattern bestmatch = null;
		for (InstructionPattern pat : patternsByMnemonic.get(mnemonic)) {
			if (matches(pat, operands)) {
				if (bestmatch == null) {
					bestmatch = pat;
				} else if (isBetterMatch(pat, bestmatch, operands)) {
					bestmatch = pat;
				}
			}
		}
		
		if (bestmatch != null)
			return bestmatch;
		else
			throw new IllegalArgumentException("No match: " + mnemonic);
	}
	
	
	private static boolean matches(InstructionPattern pat, Operand[] operands) {
		if (pat.operands.length != operands.length)
			return false;
		for (int i = 0; i < operands.length && i < operands.length; i++) {
			if (!pat.operands[i].matches(operands[i]))
				return false;
		}
		return true;
	}
	
	
	private static boolean isBetterMatch(InstructionPattern x, InstructionPattern y, Operand[] operands) {
		boolean isbetter = false;
		boolean isworse = false;
		
		for (int i = 0; i < operands.length; i++) {
			if (x.operands[i] == REL8 || x.operands[i] == REL16 || x.operands[i] == REL32) {
				// Wider is better
				isbetter |= isWider(x.operands[i], y.operands[i]);
				isworse |= isWider(y.operands[i], x.operands[i]);
			}
		}
		
		return !isworse && isbetter;
	}
	
	
	private static boolean isWider(OperandPattern x, OperandPattern y) {
		return getWidth(x) > getWidth(y);
	}
	
	
	private static int getWidth(OperandPattern op) {
		if (op == REL8)
			return 8;
		else if (op == REL16)
			return 16;
		else if (op == REL32)
			return 32;
		else
			throw new IllegalArgumentException();
	}
	
}
