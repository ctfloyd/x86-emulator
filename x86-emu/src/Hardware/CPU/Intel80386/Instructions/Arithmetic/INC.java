package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class INC implements Instruction {

	Intel80386 cpu;
	Operand dst, src;
	DataType dstType;
	
	public INC(Intel80386 cpu, Operand dst, DataType dstType) {
		this.cpu = cpu;
		this.dst = dst;
		this.dstType = dstType;
	}
	
	@Override
	public void execute() {
		// TODO: typed incerement
		int result = dst.getValue() + 1;
		
		cpu.flags.setSZP(result, dstType);
		cpu.flags.OF = result == 0x80000000; // Can only overflow if top most bit is 1, since it's increment
		cpu.flags.AF = (result & 0x0f) == 0; // If lower nibble is 0, then overflow, since it's increment
		
		dst.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("INC %s" , dst);
	}

}
