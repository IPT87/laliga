package bg.exam.laliga.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PlayerGoalsAndPassesDto {

    private String lastName;
    private int goals;
    private int assists;

}
