package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class MOVZX implements Instruction {

    CPU cpu;
    Operand dst, src;
    DataType dstType, srcType;

    public MOVZX(CPU cpu, Operand dst, Operand src, DataType dstType, DataType srcType) {
        this.cpu = cpu;
        this.dst = dst;
        this.src = src;
        this.dstType = dstType;
        this.srcType = srcType;
    }

    @Override
    public void execute() {
        if(srcType == DataType.Byte && dstType == DataType.Word) {
            // Zero extend 8-bit to 16-bit
            byte value = (byte) src.getValue();
            short dstValue = (short) (0x00FF & value);
            dst.setValue(dstValue);
        } else if (srcType == DataType.Byte && dstType == DataType.DoubleWord) {
            // Sign extend 8-bit to 32-bit
            byte value = (byte) src.getValue();
            int dstValue = 0x000000FF & value;
            dst.setValue(dstValue);
        } else if (srcType == DataType.Word && dstType == DataType.DoubleWord) {
            // Sign extned 16-bit to 32-bit
            short value = (short) src.getValue();
            int dstValue = 0x0000FFFF & value;
            dst.setValue(dstValue);
        }
    }

    @Override
    public String toString() {
        return String.format("MOVZX %s %s", dst.toString(), src.toString());
    }

}