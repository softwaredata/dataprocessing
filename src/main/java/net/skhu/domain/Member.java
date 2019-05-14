package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {

    private Long id;

    private String name;

    private Integer studentIdx;

    private String department;

    private String password;

    private String email;

    private Integer type;

    @Builder
    public Member(String name, Integer studentIdx, String department, String password, String email, int type) {
        this.name = name;
        this.studentIdx = studentIdx;
        this.department = department;
        this.password = password;
        this.email = email;
        this.type = type;
    }

}
