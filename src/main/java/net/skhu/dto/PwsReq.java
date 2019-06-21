package net.skhu.dto;


import lombok.*;

@Getter
@NoArgsConstructor
public class PwsReq {

    private Integer id; //아이디(학번)
    private String email;

    @Builder
    public PwsReq(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PwsReq{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
