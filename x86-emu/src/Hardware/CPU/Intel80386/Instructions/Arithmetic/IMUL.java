package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class IMUL implements Instruction {

	Intel80386 cpu;
	Operand dst, src;
	DataType dstType, srcType;
	
	public IMUL(Intel80386 cpu, Operand dst, Operand src, DataType dstType, DataType srcType) {
		this.cpu = cpu;
		this.src = src;
		this.srcType = srcType;
		this.dstType = dstType;
	}
	
	@Override
	public void execute() {
		assert false;
		// TODO: Unimplemented Instruction
		
	}
	
	@Override
	public String toString() {
		return String.format("IMUL %s %s", src, dst);
	}

}
