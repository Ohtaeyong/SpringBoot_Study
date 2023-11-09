package org.koreait.commons;

import org.springframework.http.HttpStatus;

import javax.xml.stream.events.Comment;

public class CommonException extends RuntimeException {

    private HttpStatus status;

    public CommonException(String message) {
        super(message);
        status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 에러
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
