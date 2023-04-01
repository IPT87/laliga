package bg.exam.laliga.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class AddPlayerFormDto {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @NotNull
    private String dateOfBirth;
    @NotNull
    @Size(min = 2, max = 20)
    private String placeOfBirth;
    @NotNull
    @Size(min = 2, max = 10)
    private String position;
    @NotNull
    @Size(min = 5, max = 60)
    private String photoUrl;
    @NotNull
    @Size(min = 5, max = 60)
    private String flagUrl;
    @Min(value = 40)
    private int weight;
    @Min(value = 130)
    private int height;
    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int goals;
    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int assists;
    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int shots;
    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int matchesPlayed;
    @NotNull
    @Min(value = 0)
    @Max(value = 5000)
    private int minutes;
    @NotNull
    @Min(value = 0)
    @Max(value = 500)
    private int starts;
    @NotNull
    @Min(value = 0)
    @Max(value = 300)
    private int substitutions;
    @NotNull
    @Min(value = 0)
    @Max(value = 500)
    private int fouls;
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private int penalties;
    @NotNull
    @Min(value = 0)
    @Max(value = 300)
    private int yellowCards;
    @NotNull
    @Min(value = 0)
    @Max(value = 300)
    private int redCards;
    @NotNull
    @Min(value = 0)
    @Max(value = 600)
    private int doubleYellowCards;
    @NotNull
    @Size(min = 2, max = 30)
    private String teamName;
    @NotNull
    @Size(min = 5, max = 60)
    private String teamLogoUrl;
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private int dorsal;

}
