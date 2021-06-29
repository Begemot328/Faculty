package com.training.faculty.web.dto;


/**
 * {@link Exception} DTO class.
 *
 * @author Yury Zmushko
 * @version 1.0
 */
public class ExceptionDTO {
    private String detailMessage;
    private int errorCode;

    /**
     * Default constructor.
     */
    public ExceptionDTO() {
        // Default constructor for Model mapper purposes.
    }

    /**
     * Constructor.
     *
     * @param e         {@link Exception} to wrap.
     */
    public ExceptionDTO(Exception e) {
        this.detailMessage = e.getMessage();
    }

    /**
     * Constructor.
     *
     * @param detailMessage Error message.
     */
    public ExceptionDTO(String detailMessage) {
        this.detailMessage = detailMessage;
        this.errorCode = errorCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}
