package net.skhu.exception;

/**
 * Created by bomi on 2019-06-10.
 */
public class JwtException extends RuntimeException {
    public JwtException(String msg) {
        super(msg);
    }
}
