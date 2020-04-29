package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class POP implements Instruction {

    Intel80386 cpu;	
    Operand src;

    public POP(Intel80386 cpu, Operand src) {
        this.cpu = cpu;
        this.src = src;
    }

    @Override
    public void execute() {
        src.setValue(cpu.popStack());
    }

    @Override
    public String toString() {
        return String.format("POP %s", src.toString());
    }

}