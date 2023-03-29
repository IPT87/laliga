package bg.exam.laliga.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mail {
    private String from;
    private String to;
    private String subject;
    private String content;
}
