package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class CBW implements Instruction {

    Intel80386 cpu;

    public CBW(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int alValue = cpu.al.getValue();
        if(alValue < 0) 
            cpu.eax.setValue(0xFFFF0000 | alValue);
        else
            cpu.eax.setValue(0x0000 | alValue);
    }

    @Override
    public String toString() {
        return String.format("CDQ");
    }

}