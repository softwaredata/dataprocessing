package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    private String name;

    private Integer studentIdx;

    private String department;

    private String password1;

    private String email;

    private Integer type;

    @Builder
    public SignUpRequest(String name, Integer studentIdx, String department, String password1, String email, Integer type) {
        this.name = name;
        this.studentIdx = studentIdx;
        this.department = department;
        this.password1 = password1;
        this.email = email;
        this.type = type;
    }
}
