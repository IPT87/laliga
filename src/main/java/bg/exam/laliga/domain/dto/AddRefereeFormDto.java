package bg.exam.laliga.domain.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddRefereeFormDto {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @NotNull
    private String dateOfBirth;
    @NotNull
    @Size(min = 2, max = 40)
    private String placeOfBirth;

    private String position;
    @NotNull
    @Size(min = 5, max = 40)
    private String photoUrl;
    @NotNull
    @Size(min = 5, max = 40)
    private String flagUrl;
    @NotNull
    @Size(min = 4, max = 15)
    private String laLigaDebut;
    @NotNull
    @Size(min = 4, max = 15)
    private String fifaDebut;

}
