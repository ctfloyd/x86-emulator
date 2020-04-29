package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataManipulation;
import Util.DataType;

public class NEG implements Instruction {

	Intel80386 cpu;
	Operand src;
	DataType srcType;
	
	public NEG(Intel80386 cpu, Operand src, DataType srcType) {
		this.cpu = cpu;
		this.src = src;
		this.srcType = srcType;
	}
	
	@Override
	public void execute() {
		int srcValue = src.getValue();
		int result = 0 - srcValue;
		
		// See @ADD.java
		// TODO: check data type and set flags accordingly
		cpu.flags.setSZP(result, srcType);
		cpu.flags.OF = (srcValue & 0x80000000) != (result & 0x80000000);
		if(srcValue == 0)
			cpu.flags.CF = false;
		else
			cpu.flags.CF = true;

		src.setValue(result);

	}
	
	@Override
	public String toString() {
		return String.format("CMP %s", src);
	}

}
