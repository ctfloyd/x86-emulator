package Util;

public class DataManipulation {

	public static int signExtend(int source, DataType srcType, DataType dstType) {
		 if(srcType == DataType.Byte && dstType == DataType.Word) {
	            // Sign extend 8-bit to 16-bit
	            byte value = (byte) source;
	            short dstValue = 0;
	            if(value < 0)
	                dstValue = (short) (0xFF00 | value);
	            else
	                dstValue = (short) (0x0000 | value);
	            return dstValue;
	        } else if (srcType == DataType.Byte && dstType == DataType.DoubleWord) {
	            // Sign extend 8-bit to 32-bit
	            byte value = (byte) source;
	            int dstValue = 0;
	            if(value < 0)
	                dstValue = 0xFFFFFF00 | value;
	            else
	                dstValue = 0x00000000 | value;
	            return dstValue;
	        } else if (srcType == DataType.Word && dstType == DataType.DoubleWord) {
	            // Sign extend 16-bit to 32-bit
	            short value = (short) source;
	            int dstValue = 0;
	            if(value < 0)
	                dstValue = 0xFFFF0000 | value;
	            else
	                dstValue = 0x00000000 | value;
	            return dstValue;
	        }
		 
		 assert false;
		 return source;
	}
	
	
}
