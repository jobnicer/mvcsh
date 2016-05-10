package org.ssh.common.exception;

import org.apache.log4j.Logger;

public class DaoException extends RuntimeException{
	private static final long serialVersionUID = -8801718407102159973L;

	private Logger log = null;

	public DaoException(Class<?> clazz, String message) {
		super(message);
		log = Logger.getLogger(clazz);
		log.error(message);
	}
	
	public DaoException(Class<?> clazz, Throwable throwable) {
		super(throwable);
		log = Logger.getLogger(clazz);
		log.error(throwable.getMessage());
	}
}
