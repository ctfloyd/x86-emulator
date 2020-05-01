package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class MUL implements Instruction {

	Intel80386 cpu;
	Operand src;
	DataType srcType;
	
	public MUL(Intel80386 cpu, Operand src, DataType srcType) {
		this.cpu = cpu;
		this.src = src;
		this.srcType = srcType;
	}
	
	@Override
	public void execute() {
		// TODO: check data type
		long result = src.getValue() * cpu.eax.getValue();
		
		// TODO: check data type and set flags accordingly
		cpu.flags.OF = cpu.flags.CF = (result & 0xFFFFFFFF00000000l) != 0; 

		cpu.edx.setValue((int)(result >>> 32));
		cpu.eax.setValue((int)(result & 0xffffffff));

	}
	
	@Override
	public String toString() {
		return String.format("MUL %s eax", src);
	}

}
