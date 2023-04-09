package bg.exam.laliga.service;

import bg.exam.laliga.services.EmailService;
import bg.exam.laliga.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    EmailService toTest;

    @Mock
    JavaMailSender javaMailSender;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        toTest = new EmailService(javaMailSender, objectMapper, userService);
    }

    @Test
    void sendEmail() {
        assertThrows(RuntimeException.class, () -> toTest.sendEmail("Bob", "bob@hop.com"));
    }

}
