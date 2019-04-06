package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {

    @NotEmpty
    private String name;

    @Column(nullable = false)
    private int studentIdx;

    @NotEmpty
    private String department;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @Column(nullable = false)
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
