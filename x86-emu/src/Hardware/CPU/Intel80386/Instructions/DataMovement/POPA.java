package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;

public class POPA implements Instruction {

    Intel80386 cpu;

    public POPA(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
    	cpu.edi.setValue(cpu.popStack());
    	cpu.esi.setValue(cpu.popStack());
    	cpu.ebp.setValue(cpu.popStack());
    	cpu.popStack();
    	cpu.ebx.setValue(cpu.popStack());
    	cpu.edx.setValue(cpu.popStack());
    	cpu.ecx.setValue(cpu.popStack());
    	cpu.eax.setValue(cpu.popStack());
    }

    @Override
    public String toString() {
        return String.format("POPA");
    }

}