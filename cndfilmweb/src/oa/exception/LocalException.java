package oa.exception;

@SuppressWarnings("serial")
public class LocalException extends UapBaseException{

	public LocalException(){
		super();
	}

	public LocalException(String msg){
		super("本地错误: " + msg);
	}

	public LocalException(String msg, Throwable cause){
		super("本地错误: " + msg, cause);
	}

	public LocalException(Throwable cause){
		super(cause);
	}
}
