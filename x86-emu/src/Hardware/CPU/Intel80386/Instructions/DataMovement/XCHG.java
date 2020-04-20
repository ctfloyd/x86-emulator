package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class XCHG implements Instruction {

    CPU cpu;
    Operand dst, src;

    public XCHG(CPU cpu, Operand dst, Operand src) {
        this.cpu = cpu;
        this.dst = dst;
        this.src = src;
    }

    @Override
    public void execute() {
        int src = this.src.getValue();
        int dst = this.dst.getValue();

        this.dst.setValue(src);
        this.src.setValue(dst);
    }

    @Override
    public String toString() {
        return String.format("XCHG %s %s", dst.toString(), src.toString());
    }

}