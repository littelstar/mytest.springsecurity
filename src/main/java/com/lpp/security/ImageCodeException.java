package com.lpp.security;

import org.springframework.security.core.AuthenticationException;

public class ImageCodeException extends AuthenticationException {
    public ImageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ImageCodeException(String msg) {
        super(msg);
    }
}
