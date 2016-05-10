package org.ssh.common.exception;

import org.apache.log4j.Logger;

public class ActionException extends Exception {

	private static final long serialVersionUID = 105188045974566349L;
	private Logger log = null;

	public ActionException(Class<?> clazz, String message) {
		super(message);
		log = Logger.getLogger(clazz);
		log.error(message);
	}
	
	public ActionException(Class<?> clazz, Throwable throwable) {
		super(throwable);
		log = Logger.getLogger(clazz);
		log.error(throwable.getMessage());
	}

}
