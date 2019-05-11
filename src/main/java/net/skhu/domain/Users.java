package net.skhu.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class Users {

    private Long id;

    private String name;

    private Integer studentIdx;

    private String department;

    private String password;

    private String email;

    private Integer type;

    @Builder
    public Users(String name, Integer studentIdx, String department, String password, String email, int type) {
        this.name = name;
        this.studentIdx = studentIdx;
        this.department = department;
        this.password = password;
        this.email = email;
        this.type = type;
    }

}
