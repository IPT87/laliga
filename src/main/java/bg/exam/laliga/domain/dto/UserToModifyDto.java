package bg.exam.laliga.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserToModifyDto {

    private String username;
    private String email;
    private String password;
    private String currentRole;
    private String role;

}
