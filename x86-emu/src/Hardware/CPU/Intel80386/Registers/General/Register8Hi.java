package Hardware.CPU.Intel80386.Registers.General;

public class Register8Hi extends Register8 {

    public Register8Hi(String name, Register32 reg32) {
        super(name, reg32);
    }

    // >>> is unsinged shift, we want to use this to get the raw hi 16 bits
    // without the MSB being filled in.
    // ---------------------------------------------------
    // | 31 - 16   eax       |  15 - 8 (AH) |  7 - 0 AL  |
    // ---------------------------------------------------
    @Override
    public int getValue() {
        return (reg32.getValue() >>> 8) & 0xff;
    }

    // Clear Hi-bits and truncate upper bits in the value (for safety) then shift
    // the low-bits of the int into the hi-bits position and bitwise or to apply
    @Override
    public void setValue(int value) {
        reg32.setValue((reg32.getValue() & 0xffff00ff) | ((value & 0xff) << 8));
    }


}