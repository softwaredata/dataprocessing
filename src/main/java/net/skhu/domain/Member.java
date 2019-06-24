package net.skhu.domain;

import com.amazonaws.services.identitymanagement.model.UserDetail;
import lombok.*;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private String name;

    private Integer studentIdx;

    private String department;

    private String password;

    private String email;

    private Integer type;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", studentIdx=" + studentIdx +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }

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
