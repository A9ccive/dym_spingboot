package com.ruoyi.common.exception;

/**
 * 自定义异常类
 * @author
 * created
 */
public class ParamException extends RuntimeException {
    private Long id;

    public ParamException(Long id) {
        super("filed not exist or is null");
        this.id = id;
    }

    public ParamException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
