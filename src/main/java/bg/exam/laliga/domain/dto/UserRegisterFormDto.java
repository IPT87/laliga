package bg.exam.laliga.domain.dto;


import bg.exam.laliga.validations.matchingPasswords.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRegisterFormDto {

    @NotNull
    @Email
    @Size(min = 5, max = 30)
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;

    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    private boolean isSubscribed;

}
