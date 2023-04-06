package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.RefereeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefereeRepository extends JpaRepository<RefereeEntity, Long> {

    Optional<RefereeEntity> findByName(String name);

}
