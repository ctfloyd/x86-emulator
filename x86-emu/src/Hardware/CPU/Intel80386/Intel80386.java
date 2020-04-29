package Hardware.CPU.Intel80386;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Hardware.CPU.Intel80386.MemoryManagement.MMU;
import Hardware.CPU.Intel80386.Registers.Flags.Flags;
import Hardware.CPU.Intel80386.Registers.General.Register16;
import Hardware.CPU.Intel80386.Registers.General.Register32;
import Hardware.CPU.Intel80386.Registers.General.Register8;
import Hardware.CPU.Intel80386.Registers.General.Register8Hi;
import Hardware.CPU.Intel80386.Registers.General.Register8Lo;
import Hardware.Memory.Memory;
import Util.DataType;

public class Intel80386 implements CPU {

    public Register32 eax, ebx, ecx, edx, esp, ebp, esi, edi;
    public Register16 ax, bx, cx, dx, sp, bp, si, di;
    public Register8 ah, bh, ch, dh, al, bl, cl, dl;
    public Flags flags;
    public MMU mmu;

    public Intel80386(Memory memory) {
        eax = new Register32("eax");
        ebx = new Register32("ebx");
        ecx = new Register32("ecx");
        edx = new Register32("edx");
        esp = new Register32("esp");
        ebp = new Register32("ebp");
        esi = new Register32("esi");
        edi = new Register32("edi");
        ax = new Register16("ax", eax);
        bx = new Register16("bx", ebx);
        cx = new Register16("cx", ecx);
        dx = new Register16("dx", edx);
        sp = new Register16("sp", esp);
        bp = new Register16("bp", ebp);
        si = new Register16("si", esi);
        di = new Register16("di", edi);
        ah = new Register8Hi("ah", eax);
        bh = new Register8Hi("bh", ebx);
        ch = new Register8Hi("ch", ecx);
        dh = new Register8Hi("dh", edx);
        al = new Register8Lo("al", eax);
        bl = new Register8Lo("bl", ebx);
        cl = new Register8Lo("cl", ecx);
        dl = new Register8Lo("dl", edx);
        flags = new Flags();
        mmu = new MMU(this, memory);


    }

    public void pushStack(int data, DataType type) {
        esp.setValue(esp.getValue() - type.byteAmount);
        writeMemory(esp.getValue(), data);
    }

    public int popStack() {
        int data = mmu.readMemory(esp.getValue());
        esp.setValue(esp.getValue() + 4);
        return data;
    }

    public void writeMemory(int address, int data) {
        mmu.writeMemory(address, data);
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}