package bg.exam.laliga.services;

import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRoleEntity findUserRoleByRole(UserRoleEnum userRoleEnum) {
        return this.userRoleRepository.findUserRoleEntityByRole(userRoleEnum).orElseThrow();
    }

}
