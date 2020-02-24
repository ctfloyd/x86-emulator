package Hardware.CPU.Intel80386.Registers.General;

import Hardware.CPU.Intel80386.Registers.Register;

public class Register32 implements Register {

    private String name;
    private int value;

    public Register32(String name) {
        this.name = name;
    }

    public void clear() {
        this.value = 0;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}