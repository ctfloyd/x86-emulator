package Hardware.CPU.Intel80386.Registers.General;

public class Register8Lo extends Register8 {

    public Register8Lo(String name, Register32 reg32) {
        super(name, reg32);
    }

    @Override
    public int getValue() {
        return reg32.getValue() & 0xff;
    }

    @Override
    public void setValue(int value) {
        reg32.setValue((reg32.getValue() & 0xffffff00) | (value & 0xff));
    }
}