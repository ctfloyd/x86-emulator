package Hardware.Memory;


public class Memory {

    int[] memory;

    public Memory(int size)  {
        this.memory = new int[size];
    }

    public void write(int address, int write) {
        memory[address] = write;
    }

    public int read(int address) {
        return memory[address];
    }
}