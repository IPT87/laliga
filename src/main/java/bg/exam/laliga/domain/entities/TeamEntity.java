package bg.exam.laliga.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year_of_foundation")
    private String yearOfFoundation;

    @Column
    private String president;

    @Column
    private String name;

    @Column(name = "official_web")
    private String officialWeb;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column(name = "matches_to_play")
    private int matchesToPlay;

    @Column
    private int wins;

    @Column
    private int draws;

    @Column
    private int loses;

    @Column
    private int points;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PlayerEntity> players;

}
