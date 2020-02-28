package Hardware.CPU.Intel80386.Instructions.Operands;

import Hardware.CPU.Intel80386.Registers.Register;

public class RegisterOperand implements Operand {

    private Register register;

    public RegisterOperand(Register register) {
        this.register = register;
    }

    @Override
    public int getValue() {
        return register.getValue();
    }

    @Override
    public void setValue(int value) {
        register.setValue(value);
    }

    @Override
    public String toString() {
        return register.toString();
    }

}