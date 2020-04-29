package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class DEC implements Instruction {

	Intel80386 cpu;
	Operand dst, src;
	DataType dstType;
	
	public DEC(Intel80386 cpu, Operand dst, DataType dstType) {
		this.cpu = cpu;
		this.dst = dst;
		this.dstType = dstType;
	}
	
	@Override
	public void execute() {
		// TODO: typed decrement
		int result = dst.getValue() - 1;
		
		cpu.flags.setSZP(result, dstType);
		cpu.flags.OF = result == 0x7fffffff;
		cpu.flags.AF = (result & 0x0f) == 0x0f; // If lower nibble is all 1, then overflowed
		
		dst.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("DEC %s" , dst);
	}

}
