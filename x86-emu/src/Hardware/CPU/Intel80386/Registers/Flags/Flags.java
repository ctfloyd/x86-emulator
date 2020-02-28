package Hardware.CPU.Intel80386.Registers.Flags;

public class Flags {

    public static final int MASK_CARRY = 0x1;
    public static final int MASK_PARITY = 0x4;
    public static final int MASK_AUXILLARY = 0x10;
    public static final int MASK_ZERO = 0x40;
    public static final int MASK_SIGN = 0x80;
    public static final int MASK_TRAP = 0x100;
    public static final int MASK_INTERRUPT = 0x200;
    public static final int MASK_DIRECTION = 0x400;
    public static final int MASK_OVERFLOW = 0X800;
    public static final int MASK_IOCONTROL = 0x3000;
    public static final int MASK_NESTED_TASK = 0x4000;
    public static final int MASK_RESUME = 0x10000;
    public static final int MASK_VIRTUAL_MODE = 0x20000;

    // Public because getters and setters here would be obnoxious
    public boolean CF; // carry flag
    public boolean PF; // parity flag
    public boolean AF; // auxillary carry
    public boolean ZF; // zero flag
    public boolean SF; // sign flag
    public boolean TF; // trap flag
    public boolean IF; // interrupt enable
    public boolean DF; // direction flag
    public boolean OF; // overflow flag
    public boolean NT; // nested task flags
    public boolean RF; // resume flag
    public boolean VM; // Virtual 8086 mode
    public byte IO; // I/O privelege level (2 bits)

    public void clear() {
        CF = false;
        PF = false;
        AF = false;
        ZF = false;
        SF = false;
        TF = false;
        IF = false;
        DF = false;
        OF = false;
        NT = false;
        RF = false;
        VM = false;

        IO = 0;
    }

    // Return entire flag register
    public int getValue() {
        int value = 0;

        value = IO << 12;
        if(CF) value |= MASK_CARRY;
        if(PF) value |= MASK_PARITY;
        if(AF) value |= MASK_AUXILLARY;
        if(ZF) value |= MASK_ZERO;
        if(SF) value |= MASK_SIGN;
        if(TF) value |= MASK_TRAP;
        if(IF) value |= MASK_INTERRUPT;
        if(DF) value |= MASK_DIRECTION;
        if(OF) value |= MASK_OVERFLOW;
        if(NT) value |= MASK_NESTED_TASK;
        if(RF) value |= MASK_RESUME;
        if(VM) value |= MASK_VIRTUAL_MODE;

        return value;
    }

    // Pass in an integer where each bit corresponds to x86 flags register bit
    // and a mask for which value we want to change.
    public void setValue(int value, int mask) {
        if((mask & MASK_CARRY) != 0)
            CF = (value & MASK_CARRY) != 0;
        if((mask & MASK_PARITY) != 0)
            PF = (value & MASK_PARITY) != 0;
        if((mask & MASK_AUXILLARY) != 0)
            AF = (value & MASK_AUXILLARY) != 0;
        if((mask & MASK_ZERO) != 0)
            ZF = (value & MASK_ZERO) != 0;
        if((mask & MASK_SIGN) != 0)
            SF = (value & MASK_SIGN) != 0;
        if((mask & MASK_TRAP) != 0)
            TF = (value & MASK_TRAP) != 0;
        if((mask & MASK_DIRECTION) != 0)
            DF = (value & MASK_DIRECTION) != 0;
        if((mask & MASK_OVERFLOW) != 0)
            OF = (value & MASK_OVERFLOW) != 0;
        if((mask & MASK_NESTED_TASK) != 0)
            NT = (value & MASK_NESTED_TASK) != 0;
        if((mask & MASK_RESUME) != 0)
            RF = (value & MASK_RESUME) != 0;
        if((mask & MASK_VIRTUAL_MODE) != 0)
            VM = (value & MASK_VIRTUAL_MODE) != 0;
        if((mask & MASK_IOCONTROL) != 0)
            IO = (byte)(value & MASK_IOCONTROL);

    }

    @Override
    public String toString() {
        //VRN[IO]ODITSZAPC
        StringBuilder flags = new StringBuilder();
        flags.append(VM ? "V" : "v");
        flags.append(RF ? "R" : "r");
        flags.append(NT ? "N" : "n");
        flags.append(IO);
        flags.append(OF ? "O" : "o");
        flags.append(DF ? "D" : "d");
        flags.append(IF ? "I" : "i");
        flags.append(TF ? "T" : "t");
        flags.append(AF ? "A" : "a");
        flags.append(PF ? "P" : "p");
        flags.append(CF ? "C" : "c");
        return String.format("%s%s%s[%02x]%s%s%s%s%s%5s%s%s%s", flags);
    }

}