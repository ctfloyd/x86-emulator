package Hardware.CPU.Intel80386.Instructions.Logical;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class NOT implements Instruction {

	Intel80386 cpu;
	Operand src;
	
	public NOT(Intel80386 cpu, Operand src) {
		this.cpu = cpu;
		this.src = src;
	}
	
	@Override
	public void execute() {
		int result = ~(src.getValue());
		src.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("NOT %s", src);
	}

}