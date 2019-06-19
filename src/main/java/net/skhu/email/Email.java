package net.skhu.email;

import lombok.*;

@Getter
@NoArgsConstructor
public class Email {
    private String sender;//보내는사람

    private String recipient;//받는사람

    private String subject;//제목

    private String content;//내용

    @Builder
    public Email(String sender, String recipient, String subject, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }
}
