package com.github.hicolors.leisure.common.framework.springmvc.response;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {

    /**
     * 错误发生时间
     */
    private Date timestamp;

    /**
     * 对应浏览器状态
     */
    private Integer status;

    /**
     * 状态码错误说明
     */
    private String error;

    /**
     * 定义的具体错误码
     */
    private Long code;

    /**
     * 请求出错的地址
     */
    private String path;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 原始异常信息
     */
    private String exception;

    /**
     * 当验证错误时，各项具体的错误信息
     */
    private List<Error> errors;

    public ErrorResponse(HttpServletRequest request) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.path = request.getRequestURI();
    }

    public void addError(String name, String message) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(new Error(name, message));
    }

    class Error {

        private String name;

        private String message;

        public Error(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}