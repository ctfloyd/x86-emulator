package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataManipulation;
import Util.DataType;

public class CMP implements Instruction {

	Intel80386 cpu;
	Operand dst, src;
	DataType dstType, srcType;
	
	public CMP(Intel80386 cpu, Operand dst, Operand src, DataType dstType, DataType srcType) {
		this.cpu = cpu;
		this.dst = dst;
		this.src = src;
		this.dstType = dstType;
		this.srcType = srcType;
	}
	
	@Override
	public void execute() {
		int srcValue = src.getValue();
		if(srcType != dstType) {
			srcValue = DataManipulation.signExtend(srcValue, srcType, dstType);
		}
		int dstValue = dst.getValue();
		int result = dstValue - srcValue;
		
		// See @ADD.java
		// TODO: check data type and set flags accordingly
		cpu.flags.setSZP(result, dstType);
		cpu.flags.CF = Integer.compareUnsigned(result, result) < 0;
		cpu.flags.OF = ((srcValue & 0x80000000) ^ (dstValue & 0x80000000)) != (result & 0x80000000);
		cpu.flags.AF = (((dstValue ^ srcValue) ^ result) & 0x10) != 0;

	}
	
	@Override
	public String toString() {
		return String.format("CMP %s %s", dst, src);
	}

}
