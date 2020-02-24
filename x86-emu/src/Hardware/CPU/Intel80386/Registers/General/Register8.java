package Hardware.CPU.Intel80386.Registers.General;

import Hardware.CPU.Intel80386.Registers.Register;

public abstract class Register8 implements Register {

    String name;
    Register32 reg32;

    public Register8(String name, Register32 reg32) {
        this.name = name;
        this.reg32 = reg32;
    }

    @Override
    public String toString() {
        return this.name;
    }
}