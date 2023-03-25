package bg.exam.laliga.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stadiums")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StadiumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @Column(name = "year_of_construction")
    private String yearOfConstruction;

    @Column
    private int capacity;

    @Column(name = "photo_url")
    private String photoUrl;

}
