package it.quix.experis.quixacademy.core.manager;

import it.quix.framework.core.exception.ApplicationException;

/**
 * Application exception thrown by this project Manager
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class QuixacademyException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    /**
     * Basic constructor
     */
    public QuixacademyException() {
        super();
    }

    /**
     * @param additionalData additional object to describe the exception
     */
    public QuixacademyException(Object... additionalData) {
        super(additionalData);
    }

    /**
     * @param message message to describe the exception
     * @param additionalData additional object to describe the exception
     */
    public QuixacademyException(String message, Object... additionalData) {
        super(message, additionalData);
    }

    /**
     * @param message message to describe the exception
     * @param th throwable that generate the error
     * @param additionalData
     */
    public QuixacademyException(String message, Throwable th, Object... additionalData) {
        super(message, th, additionalData);
    }

    /**
     * @param message message to describe the exception
     * @param th throwable that generate the error
     */
    public QuixacademyException(String message, Throwable th) {
        super(message, th);
    }

    /**
     * @param message message to describe the exception
     */
    public QuixacademyException(String message) {
        super(message);
    }

    /**
     * @param th throwable that generate the error
     * @param additionalData
     */
    public QuixacademyException(Throwable th, Object... additionalData) {
        super(th, additionalData);
    }

    /**
     * @param th throwable that generate the error
     */
    public QuixacademyException(Throwable th) {
        super(th);
    }

}
