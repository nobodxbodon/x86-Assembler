package org.p79068.assembler.operand;


/**
 * A 32-bit memory reference.
 * @see Register32
 */
public final class Memory32 extends Operand {
	
	/** The base register, which may be {@code null}. */
	private Register32 base;
	
	/** The scale, which is either 1, 2, 4, or 8. */
	private int scale;
	
	/** The index register, which is not {@link Register32}.ESP_REGISTER, and may be {@code null}. */
	private Register32 index;
	
	/** The displacement, which is not {@code null}. */
	private Immediate displacement;
	
	
	
	/**
	 * Constructs a memory32 operand with the specified base, index, scale, and displacement. The base register may be {@code null}. The index register may be {@code null}, but must not be {@link Register32}.ESP_REGISTER. The scale must be either 1, 2, 4, or 8. The displacement must not be {@code null}.
	 * @param base the base register, possibly {@code null}
	 * @param scale the index scale, either 1, 2, 4, or 8
	 * @param index the index register, possibly {@code null}
	 * @param displacement the displacement, which is not {@code null}
	 */
	public Memory32(Register32 base, int scale, Register32 index, Immediate displacement) {
		if (index == Register32.ESP_REGISTER)
			throw new IllegalArgumentException("Invalid index register");
		if (scale != 1 && scale != 2 && scale != 4 && scale != 8)
			throw new IllegalArgumentException("Invalid scale");
		if (displacement == null)
			throw new NullPointerException();
		
		this.base = base;
		this.scale = scale;
		this.index = index;
		this.displacement = displacement;
	}
	
	
	
	/**
	 * Returns the base register. It may be {@code null}.
	 * @return the base register
	 */
	public Register32 getBase() {
		return base;
	}
	
	
	/**
	 * Returns the index register. It may be {@code null}. It is not ESP.
	 * @return the index register
	 */
	public Register32 getIndex() {
		return index;
	}
	
	
	/**
	 * Returns the index scale. It is either 1, 2, 4, or 8. It is not any other value.
	 * @return the index scale
	 */
	public int getScale() {
		return scale;
	}
	
	
	/**
	 * Returns the displacement. It is not {@code null}.
	 * @return the displacement
	 */
	public Immediate getDisplacement() {
		return displacement;
	}
	
	
	/**
	 * Returns a string representation of this memory reference.
	 * @return a string representation of this memory reference
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		boolean hasTerm = false;
		
		if (base != null) {
			if (hasTerm) sb.append("+");
			else hasTerm = true;
			sb.append(base);
		}
		
		if (index != null) {
			if (hasTerm) sb.append("+");
			else hasTerm = true;
			sb.append(index);
			if (scale != 1)
				sb.append("*").append(scale);
		}
		
		if (displacement.getValue() != 0 || !hasTerm) {
			if (hasTerm) sb.append("+");
			else hasTerm = true;
			sb.append(displacement);
		}
		
		sb.append("]");
		return sb.toString();
	}
	
}