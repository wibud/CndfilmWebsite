package oa.dao;

import oa.exception.RemoteException;

@SuppressWarnings("serial")
public class DaoRemoteException extends RemoteException {

	public DaoRemoteException(){
		super();
	}

	public DaoRemoteException(String msg){
		super(msg);
	}

	public DaoRemoteException(String msg, Throwable cause){
		super(msg, cause);
	}

	public DaoRemoteException(Throwable cause){
		super(cause);
	}
}
