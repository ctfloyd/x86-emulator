package Hardware.CPU.Intel80386.Instructions.Logical;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class AND implements Instruction {

	Intel80386 cpu;
	Operand src, dst;
	DataType type;
	
	public AND(Intel80386 cpu, Operand dst, Operand src, DataType type ) {
		this.cpu = cpu;
		this.src = src;
		this.dst = dst;
		this.type = type;
	}
	
	@Override
	public void execute() {
		int srcValue = src.getValue();
		int dstValue = dst.getValue();
		int result = dstValue & srcValue;
		
		cpu.flags.setSZP(result, type);
		cpu.flags.OF = false;
		cpu.flags.CF = false;
		
		dst.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("AND %s %s", dst, src);
	}

}