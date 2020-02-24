package Hardware.CPU.Intel80386.Registers.General;

import Hardware.CPU.Intel80386.Registers.Register;

// The 16 low bits of a 32-bit register
public class Register16 implements Register {

    private String name;
    private Register32 reg32;

    public Register16(String name, Register32 reg32) {
        this.name = name;
        this.reg32 = reg32;
    }

    @Override
    public int getValue() {
        return reg32.getValue() & 0xffff;
    }

    @Override
    // Clear the 16 low bits in register then or with 16 low bits of int value
    public void setValue(int value) {
        reg32.setValue((reg32.getValue() & 0xffff0000) | (value & 0xffff));
    }

    @Override
    public String toString() {
        return name;
    }
    
}