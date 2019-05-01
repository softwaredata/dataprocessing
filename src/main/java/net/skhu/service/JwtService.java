package net.skhu.service;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2019-04-22.
 */

@Slf4j
@Service
public class JwtService {
    //@Value("")
    private String ISSUER;

    //@Value("")
    private String SECRET;

    public String create(final int idx) {
        return null;
    }

    public Token decode(final String token) {
        return null;
    }

    public static class Token {
        private int userIdx = -1;

        public Token() { }
        public Token(final int userIdx) {
            this.userIdx = userIdx;
        }

        public int getUserIdx() {
            return this.userIdx;
        }
    }

    public static class TokenRes {
        private String token;

        public TokenRes() {}
        public TokenRes(final String token) {
            this.token = token;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
