package bg.exam.laliga.domain.dto;

import bg.exam.laliga.domain.entities.PlayerEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddTeamFormDto {
    @NotNull
    private String yearOfFoundation;

    @NotNull
    @Size(min = 2, max = 40)
    private String president;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;

    @NotNull
    @Size(min = 5, max = 30)
    private String officialWeb;

    @NotNull
    @Size(min = 5, max = 40)
    private String photoUrl;

    @NotNull
    @Size(min = 2, max = 50)
    private String coachName;

    @NotNull
    @Size(min = 2, max = 30)
    private String stadiumName;

    @NotNull
    @Size(min = 5, max = 30)
    private String stadiumPhotoUrl;

    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int matchesPlayed;

    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int matchesToPlay;

    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int wins;

    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int draws;

    @NotNull
    @Min(value = 0)
    @Max(value = 200)
    private int loses;

    @NotNull
    @Min(value = 0)
    @Max(value = 600)
    private int points;

    @NotNull
    private List<String> players;

}
