package Util;

public enum DataType {
    Byte(1),
    Word(2),
    DoubleWord(4),
    QuadWord(8);

    public final int byteAmount;   

    private DataType(int byteAmount) {
        this.byteAmount = byteAmount;
    }
}