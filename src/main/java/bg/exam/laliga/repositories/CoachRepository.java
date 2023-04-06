package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long> {

    Optional<CoachEntity> findByNameAndLastName(String name, String lastName);

}
