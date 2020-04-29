package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class PUSHA implements Instruction {

    Intel80386 cpu;

    public PUSHA(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int initialStackValue = cpu.esp.getValue();
        cpu.pushStack(cpu.eax.getValue(), 4);
        cpu.pushStack(cpu.ecx.getValue(), 4);
        cpu.pushStack(cpu.edx.getValue(), 4);
        cpu.pushStack(cpu.ebx.getValue(), 4);
        cpu.pushStack(initialStackValue , 4);
        cpu.pushStack(cpu.ebp.getValue(), 4);
        cpu.pushStack(cpu.esi.getValue(), 4);
        cpu.pushStack(cpu.edi.getValue(), 4);
    }

    @Override
    public String toString() {
        return "PUSHA";
    }

}