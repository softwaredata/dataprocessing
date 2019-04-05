package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    Long id;

    String name;

    @Column(name = "student_Idx")
    int studentIdx;

    String department;

    String password;

    String email;

    int type;

    @Builder
    public Users(String name, int studentIdx, String department, String password, String email, int type) {
        this.name = name;
        this.studentIdx = studentIdx;
        this.department = department;
        this.password = password;
        this.email = email;
        this.type = type;
    }

}
