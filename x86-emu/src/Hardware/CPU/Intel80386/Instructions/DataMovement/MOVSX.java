package Hardware.CPU.Intel80386.Instructions.DataMovement;

import Util.DataType;
import Util.DataManipulation;
import Hardware.CPU.CPU;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;

public class MOVSX implements Instruction {

    CPU cpu;
    Operand dst, src;
    DataType dstType, srcType;

    public MOVSX(CPU cpu, Operand dst, Operand src, DataType dstType, DataType srcType) {
        this.cpu = cpu;
        this.dst = dst;
        this.src = src;
        this.dstType = dstType;
        this.srcType = srcType;
    }

    @Override
    public void execute() {
    	int result = DataManipulation.signExtend(src.getValue(), srcType, dstType);
    	dst.setValue(result);
    }

    @Override
    public String toString() {
        return String.format("MOVSX %s %s", dst.toString(), src.toString());
    }

}