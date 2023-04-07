package bg.exam.laliga.services;

import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.mail.Mail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final ObjectMapper mapper;
    private final UserService userService;

    @Autowired
    public EmailService(JavaMailSender emailSender, ObjectMapper mapper, UserService userService) {
        this.emailSender = emailSender;
        this.mapper = mapper;
        this.userService = userService;
    }

    public void sendEmail(String userName, String userEmail) {

        Mail mail;
        try {
            mail = mapper.readValue(new File("src/main/resources/emailData.json"), Mail.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            mail.setTo(userEmail);
            mail.setContent("Hello, " + userName + "!\n\n" + mail.getContent());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(mail.getSubject());
            message.setFrom(mail.getFrom());
            message.setTo(mail.getTo());
            message.setText(mail.getContent());

            emailSender.send(message);

    }

    @Scheduled(cron = "0 0 0 * * *")
    public void sendNewsEmail() {

        List<UserEntity> users = this.userService.getAllUsers();

        users.forEach(userEntity -> {
            if (userEntity.getIsSubscribed().equals("on")) {
                sendEmail(userEntity.getUsername(), userEntity.getEmail());
            }
        });

    }

}
