package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.UserRegisterFormDto;
import bg.exam.laliga.domain.dto.UserToModifyDto;
import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    public void registerUser(UserRegisterFormDto userRegisterFormDto) {
        UserEntity userToSave = this.mapper.map(userRegisterFormDto, UserEntity.class);
        userToSave.setPassword(passwordEncoder.encode(userRegisterFormDto.getPassword()));
        UserRoleEntity userRoleEntity = this.userRoleService.findUserRoleByRole(UserRoleEnum.USER);
        userToSave.setRoles(List.of(userRoleEntity));

        this.userRepository.save(userToSave);
    }

    public UserEntity getUser(String username) {
        return this.userRepository.findByUsername(username).orElseThrow();
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity) {
        this.userRepository.saveAndFlush(userEntity);
    }

    @Transactional
    public void deleteUser(String username) {
        this.userRepository.deleteUserEntityByUsername(username);
    }

    public void changeUserRole(UserToModifyDto userModified) {

        UserRoleEntity roleToAdd = this.userRoleService.findUserRoleByRole(UserRoleEnum.valueOf(userModified.getRole()));

        UserEntity existingUser = getUser(userModified.getUsername());
        System.out.println();
        if (userModified.getCurrentRole() != null) {

            UserRoleEntity currentRole = this.userRoleService.findUserRoleByRole(UserRoleEnum.valueOf(userModified.getCurrentRole()));
            existingUser.getRoles().remove(currentRole);
            this.userRepository.saveAndFlush(existingUser);

        }

        if (!existingUser.getRoles().contains(roleToAdd)) {
            existingUser.getRoles().add((roleToAdd));
            this.userRepository.saveAndFlush(existingUser);
        }
        System.out.println();
        saveUser(existingUser);

    }

}
