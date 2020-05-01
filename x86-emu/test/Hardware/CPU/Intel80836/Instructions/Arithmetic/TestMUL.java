package Hardware.CPU.Intel80836.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Arithmetic.MUL;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Hardware.CPU.Intel80386.Instructions.Operands.RegisterOperand;
import Hardware.CPU.Intel80386.Registers.Register;
import Hardware.CPU.Intel80386.Registers.General.Register32;
import Hardware.Memory.Memory;
import Util.DataType;

public class TestMUL {
	
	public TestMUL() {
		
	}

	public static void main(String[] args) {
		Intel80386 cpu = new Intel80386(new Memory(512));
		cpu.eax.setValue(2);
		Register test = new Register32("test");
		Operand src = new RegisterOperand(test);
		test.setValue(Integer.MAX_VALUE);
		new MUL(cpu, src, DataType.DoubleWord).execute();
		
		long expected = Integer.MAX_VALUE * 2;
		int hiBits = cpu.edx.getValue();
		int loBits = cpu.eax.getValue();
		long computed = (0xFFFFFFFF00000000l & hiBits) | loBits;
		
		if(expected != computed)
			assert false;
	}

}
