package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Hardware.CPU.Intel80386.Exceptions.ProccesorDivideByZeroException;;
import Util.DataType;

public class DIV implements Instruction {

	Intel80386 cpu;
	Operand src;
	DataType srcType;
	
	public DIV(Intel80386 cpu, Operand src, DataType srcType) {
		this.cpu = cpu;
		this.src = src;
		this.srcType = srcType;
	}
	
	@Override
	public void execute() {
		// TODO: check data type
		int srcValue = src.getValue();
		if(srcValue == 0)
			throw new ProccesorDivideByZeroException();
		
		long dividend = (cpu.edx.getValue() << 32) | (cpu.eax.getValue());
		long quotient = Long.divideUnsigned(dividend, (long)srcValue);
		long remainder = Long.remainderUnsigned(dividend, (long)srcValue);
		
		cpu.eax.setValue((int)quotient);
		cpu.edx.setValue((int)remainder);
	}
	
	@Override
	public String toString() {
		return String.format("DIV %s %s", src);
	}

}
