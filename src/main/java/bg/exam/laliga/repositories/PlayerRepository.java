package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findByName(String name);

    List<PlayerEntity> findAllByTeamName(String teamName);

}
