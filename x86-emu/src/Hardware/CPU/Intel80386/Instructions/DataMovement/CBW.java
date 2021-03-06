package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;

public class CBW implements Instruction {

    Intel80386 cpu;

    public CBW(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int alValue = cpu.al.getValue();
        if(alValue < 0) 
            cpu.eax.setValue(0xFFFFFF00 | alValue);
        else
            cpu.eax.setValue(0x000000 | alValue);
    }

    @Override
    public String toString() {
        return String.format("CBW");
    }

}