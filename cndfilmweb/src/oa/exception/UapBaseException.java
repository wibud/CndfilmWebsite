package oa.exception;

@SuppressWarnings("serial")
public class UapBaseException extends RuntimeException{

	public UapBaseException(){
		super();
	}

	public UapBaseException(String msg){
		super(msg);
	}

	public UapBaseException(String msg, Throwable cause){
		super(msg, cause);
	}

	public UapBaseException(Throwable cause){
		super(cause);
	}
}
