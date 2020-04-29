package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class PUSH implements Instruction {

    Intel80386 cpu;
    Operand src;

    public PUSH(Intel80386 cpu, Operand src) {
        this.cpu = cpu;
        this.src = src;
    }

    @Override
    public void execute() {
        cpu.pushStack(src, 4);
    }

    @Override
    public String toString() {
        return String.format("PUSH %s", src.toString());
    }

}