package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;

public class CWDE implements Instruction {

    Intel80386 cpu;

    public CWDE(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int axValue = cpu.ax.getValue();
        if(axValue < 0) 
            cpu.eax.setValue(0xFFFF0000 | axValue);
        else
            cpu.eax.setValue(0x0000 | axValue);
    }

    @Override
    public String toString() {
        return String.format("CWDE");
    }

}