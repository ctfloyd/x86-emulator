package Hardware.CPU.Intel80386.Exceptions;

public class ProccesorDivideByZeroException extends ProcessorException {

	private static final long serialVersionUID = 1664817062306463406L;

	public ProccesorDivideByZeroException() {
		super("divide by zero");
	}
	
}
