package bg.exam.laliga.repositories;

import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findUserRoleEntityByRole(UserRoleEnum role);
}
