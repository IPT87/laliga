package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.LeaderboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderboardEntity, Long> {
}
