package bg.exam.laliga.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerEntity extends BaseEntity {

    @Column
    private int weight;

    @Column
    private int height;

    @Column
    private int goals;

    @Column
    private int assists;

    @Column
    private int shots;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column
    private int minutes;

    @Column
    private int starts;

    @Column
    private int substitutions;

    @Column
    private int fouls;

    @Column
    private int penalties;

    @Column(name = "yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    private int redCards;

    @Column(name = "double_yellow_cards")
    private int doubleYellowCards;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_logo_url")
    private String teamLogoUrl;

    @Column
    private int dorsal;

}
