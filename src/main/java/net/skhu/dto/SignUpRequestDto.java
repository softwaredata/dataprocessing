package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {

    private String name;

    private int studentIdx;

    private String department;

    private String password;

    private String email;

    private int type;

    @Builder
    public SignUpRequestDto(String name, int studentIdx, String department, String password, String email, int type) {
        this.name = name;
        this.studentIdx = studentIdx;
        this.department = department;
        this.password = password;
        this.email = email;
        this.type = type;
    }
}
