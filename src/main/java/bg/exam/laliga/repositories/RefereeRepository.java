package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.RefereeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends JpaRepository<RefereeEntity, Long> {
}
