package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;


public class CDQ implements Instruction {

    Intel80386 cpu;

    public CDQ(Intel80386 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void execute() {
        int eaxValue = cpu.eax.getValue();
        if(eaxValue < 0)
            cpu.edx.setValue(0xFFFFFFFF);
        else
            cpu.edx.setValue(0);
    }

    @Override
    public String toString() {
        return String.format("CDQ");
    }

}