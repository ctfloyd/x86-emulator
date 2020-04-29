package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class PUSH implements Instruction {

    Intel80386 cpu;
    Operand src;

    public PUSH(Intel80386 cpu, Operand src) {
        this.cpu = cpu;
        this.src = src;
    }

    @Override
    public void execute() {
        cpu.pushStack(src.getValue(), DataType.DoubleWord);
    }

    @Override
    public String toString() {
        return String.format("PUSH %s", src.toString());
    }

}