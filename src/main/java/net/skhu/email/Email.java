package net.skhu.email;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String sender;//보내는사람

    private String recipient;//받는사람

    private String subject;//제목

    private String content;//내용
}
