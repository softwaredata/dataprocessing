package net.skhu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by bomi on 2019-04-22.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private int idx;
    private String password;
}
