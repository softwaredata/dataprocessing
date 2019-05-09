package net.skhu.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PwsReq {

    private Integer studentIdx;
    private String password;
    private String email;


}
