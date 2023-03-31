package bg.exam.laliga.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TeamStandingsDto {

    private String name;
    private String photoUrl;
    private int wins;
    private int draws;
    private int loses;
    private int points;

}
