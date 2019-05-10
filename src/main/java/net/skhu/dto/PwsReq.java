package net.skhu.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PwsReq {

    private int id; //아이디(학번)
    private String email;

}
