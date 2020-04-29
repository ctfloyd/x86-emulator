package Hardware.CPU.Intel80386.MemoryManagement;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.Memory.Memory;

public class MMU {

    private Intel80386 cpu;
    private Memory memory;

    public MMU(Intel80386 cpu, Memory memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    public void writeMemory(int address, int data) {
        memory.write(translateToPhysical(address), data);
    }

    public int readMemory(int address) {
        return memory.read(translateToPhysical(address));
    }

    public int translateToPhysical(int vAddress) {
        return address;
    }

}