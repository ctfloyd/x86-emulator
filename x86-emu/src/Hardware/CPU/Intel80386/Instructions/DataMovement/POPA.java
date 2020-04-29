package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class POPA implements Instruction {

    Intel80386 cpu;

    public POPA(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        cpu.popStack(cpu.edi, 4);
        cpu.popStack(cpu.esi, 4);
        cpu.popStack(cpu.ebp, 4);
        cpu.popStack(null, 4);
        cpu.popStack(cpu.ebx, 4);
        cpu.popStack(cpu.edx, 4);
        cpu.popStack(cpu.ecx, 4);
        cpu.popStack(cpu.ebx, 4);
        cpu.popStack(cpu.eax, 4);
    }

    @Override
    public String toString() {
        return String.format("POPA", src.toString());
    }

}