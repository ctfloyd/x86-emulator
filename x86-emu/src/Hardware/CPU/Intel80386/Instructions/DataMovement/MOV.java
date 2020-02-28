package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class MOV implements Instruction {

    CPU cpu;
    Operand dst, src;

    public MOV(CPU cpu, Operand dst, Operand src) {
        this.cpu = cpu;
        this.dst = dst;
        this.src = src;
    }

    @Override
    public void execute() {
        dst.setValue(src.getValue());
    }

    @Override
    public String toString() {
        return String.format("MOV %s %s", dst.toString(), src.toString());
    }

}