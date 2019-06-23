package net.skhu.config.jwt;

/**
 * Created by bomi on 2019-06-20.
 */
public class TokenRes {
    //실제 토큰
    private String token;

    public TokenRes() {
    }

    public TokenRes(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
