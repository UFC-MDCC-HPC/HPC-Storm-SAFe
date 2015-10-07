package br.ufc.mdcc.pargo.safe.framework.exception;

public class HShelfException extends Exception{

	private static final long serialVersionUID = -447218810037244768L;

	public HShelfException() {
		super("SAFe Generic Exception.");
	}
	
	public HShelfException(String msg){
		super(msg);
	}
}
