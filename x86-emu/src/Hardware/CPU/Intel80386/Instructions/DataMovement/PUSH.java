package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class PUSH implements Instruction {

    CPU cpu;
    Operand src;

    public PUSH(CPU cpu, Operand src) {
        this.cpu = cpu;
        this.src = src;
    }

    @Override
    public void execute() {
        cpu.pushStack(src);
    }

    @Override
    public String toString() {
        return String.format("PUSH %s", src.toString());
    }

}