package org.p79068.assembler.operand;


/**
 * A segment register operand. Immutable.
 */
public final class SegmentRegister extends Register {
	
	/** The ES register. */
	public static SegmentRegister ES_REGISTER = new SegmentRegister("%es", 0);
	
	/** The CS register. */
	public static SegmentRegister CS_REGISTER = new SegmentRegister("%cs", 1);
	
	/** The SS register. */
	public static SegmentRegister SS_REGISTER = new SegmentRegister("%ss", 2);
	
	/** The DS register. */
	public static SegmentRegister DS_REGISTER = new SegmentRegister("%ds", 3);
	
	/** The FS register. */
	public static SegmentRegister FS_REGISTER = new SegmentRegister("%fs", 4);
	
	/** The GS register. */
	public static SegmentRegister GS_REGISTER = new SegmentRegister("%gs", 5);
	
	
	
	private SegmentRegister(String name, int registerNumber) {
		super(name, registerNumber);
	}
	
}
