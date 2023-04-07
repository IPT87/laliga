package bg.exam.laliga.domain.dto;


import bg.exam.laliga.validations.matchingPasswords.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "You must enter an e-mail")
    @Email(message = "Please enter a valid e-mail")
    private String email;

    @NotNull
    @Size(min = 5, message = "Password should be at least 5 characters long")
    private String password;

    @NotNull
    @Size(min = 5, message = "Password should be at least 5 characters long")
    private String confirmPassword;

    @NotBlank(message = "Name can`t be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 end 20 symbols long")
    private String username;

    private String isSubscribed;

}
