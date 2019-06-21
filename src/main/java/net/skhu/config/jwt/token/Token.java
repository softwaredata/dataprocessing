package net.skhu.config.jwt.token;

/**
 * Created by bomi on 2019-06-20.
 */
public class Token {
    //토큰에 담길 정보 필드
    //초기값을 -1로 설정함으로써 로그인 실패시 -1반환
    private String userName;
    private String userRole;

    public Token() {
    }

    public Token(final String userName, final String userRole) {
        this.userName = userName;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRole() {
        return userRole;
    }
}
