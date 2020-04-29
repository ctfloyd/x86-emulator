package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;

public class CWD implements Instruction {

    Intel80386 cpu;

    public CWD(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int axValue = cpu.ax.getValue();
        if(axValue < 0)
            cpu.dx.setValue(0xFFFF);
        else
            cpu.dx.setValue(0);
    }

    @Override
    public String toString() {
        return String.format("CWD");
    }

}