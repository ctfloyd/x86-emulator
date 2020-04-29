package Hardware.CPU.Intel80386.Instructions.Logical;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class OR implements Instruction {

	Intel80386 cpu;
	Operand src, dst;
	DataType type;
	
	public OR(Intel80386 cpu, Operand dst, Operand src, DataType type ) {
		this.cpu = cpu;
		this.src = src;
		this.dst = dst;
		this.type = type;
	}
	
	@Override
	public void execute() {
		int srcValue = src.getValue();
		int dstValue = dst.getValue();
		int result = dstValue | srcValue;
		
		cpu.flags.setSZP(result, type);
		cpu.flags.OF = false;
		cpu.flags.CF = false;
		// AF is undefined, so we don't have to worry about it
		// 	Intel 80386 Programmer's Reference Manual: page 357
		//  See: https://css.csail.mit.edu/6.858/2014/readings/i386.pdf
		
		dst.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("OR %s %s", dst, src);
	}

}