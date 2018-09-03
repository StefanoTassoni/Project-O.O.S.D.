package controller.exception;


import controller.exception.enums.ErrorCode;
import controller.utils.ErrorManager;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 2843037748030063586L;

	public ServiceException(ErrorCode msg){
       this(msg, null);
    }

	public ServiceException(ErrorCode error, Throwable e){
		super(error.getCode(), e);
		ErrorManager.registerError(error);
    }
    
}
