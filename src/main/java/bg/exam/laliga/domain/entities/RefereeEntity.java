package bg.exam.laliga.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "referees")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RefereeEntity extends BaseEntity {

    @Column(name = "la_liga_debut")
    private String laLigaDebut;

    @Column(name = "fifa_debut")
    private String fifaDebut;

}
