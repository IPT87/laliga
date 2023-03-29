package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.UserRegisterFormDto;
import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegisterFormDto userRegisterFormDto) {
        UserEntity userToSave = this.mapper.map(userRegisterFormDto, UserEntity.class);
        userToSave.setPassword(passwordEncoder.encode(userRegisterFormDto.getPassword()));
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(UserRoleEnum.USER);
        userToSave.setRoles(List.of(userRoleEntity));

        this.userRepository.save(userToSave);
    }

    public UserEntity getUser(String username) {
        return this.userRepository.findByUsername(username).get();
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

}
