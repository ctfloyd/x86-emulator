package Hardware.CPU.Intel80386.Instructions.Arithmetic;

import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Instructions.Operands.Operand;
import Util.DataType;

public class SBB implements Instruction {

	Intel80386 cpu;
	Operand dst, src;
	DataType dstType, srcType;
	
	public SBB(Intel80386 cpu, Operand dst, Operand src, DataType dstType, DataType srcType) {
		this.cpu = cpu;
		this.dst = dst;
		this.src = src;
		this.dstType = dstType;
		this.srcType = srcType;
	}
	
	@Override
	public void execute() {
		// TODO: Do operations based on data types
		int srcValue = src.getValue();
		int dstValue = dst.getValue();
		int result = srcValue - dstValue;
		
		if(cpu.flags.CF)
			result -= 1;
		
		cpu.flags.setSZP(result, dstType);
		cpu.flags.CF = Integer.compareUnsigned(result, result) < 0;
		// OF flag is set if: top-most bit of src XOR top-most bit of dst != top-most bit of result
		cpu.flags.OF = ((srcValue & 0x80000000) ^ (dstValue & 0x80000000)) != (result & 0x80000000);
		// x  ^ y ^ z, effectively computes the value that "should be" at 0x10;
		cpu.flags.AF = (((dstValue ^ srcValue) ^ result) & 0x10) != 0;
				
		dst.setValue(result);
	}
	
	@Override
	public String toString() {
		return String.format("SBB %s %s", dst, src);
	}

}
