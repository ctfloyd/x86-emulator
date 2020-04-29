package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Util.DataType;

public class PUSHA implements Instruction {

    Intel80386 cpu;

    public PUSHA(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int initialStackValue = cpu.esp.getValue();
        cpu.pushStack(cpu.eax.getValue(), DataType.DoubleWord);
        cpu.pushStack(cpu.ecx.getValue(), DataType.DoubleWord);
        cpu.pushStack(cpu.edx.getValue(), DataType.DoubleWord);
        cpu.pushStack(cpu.ebx.getValue(), DataType.DoubleWord);
        cpu.pushStack(initialStackValue , DataType.DoubleWord);
        cpu.pushStack(cpu.ebp.getValue(), DataType.DoubleWord);
        cpu.pushStack(cpu.esi.getValue(), DataType.DoubleWord);
        cpu.pushStack(cpu.edi.getValue(), DataType.DoubleWord);
    }

    @Override
    public String toString() {
        return "PUSHA";
    }

}