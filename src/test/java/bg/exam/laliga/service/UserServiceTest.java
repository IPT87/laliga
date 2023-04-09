package bg.exam.laliga.service;

import bg.exam.laliga.domain.dto.UserRegisterFormDto;
import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.repositories.UserRepository;
import bg.exam.laliga.services.UserRoleService;
import bg.exam.laliga.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private final String EXISTING_USER_NAME = "Ivo";
    private final String NOT_EXISTING_USER_NAME = "Donald";

    private UserService toTest;

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRoleService userRoleService;
    @InjectMocks
    private UserService mockUserService;
    @Captor
    private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new UserService(
                mockUserRepository,
                modelMapper,
                passwordEncoder,
                userRoleService
        );
    }

    @Test
    void saveUser() {

    }

    @Test
    void testUserFound() {

        UserRoleEntity testUserRoleAdmin = new UserRoleEntity();
        testUserRoleAdmin.setRole(UserRoleEnum.ADMIN);
        UserRoleEntity testUserRoleUser = new UserRoleEntity();
        testUserRoleUser.setRole(UserRoleEnum.USER);

        UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername(EXISTING_USER_NAME);
        testUserEntity.setPassword("Pass1");
        testUserEntity.setRoles(List.of(testUserRoleAdmin, testUserRoleUser));

        when(mockUserRepository.findByUsername(EXISTING_USER_NAME)).thenReturn(Optional.of(testUserEntity));

        UserEntity testUser = toTest.getUser(EXISTING_USER_NAME);

        Assertions.assertNotNull(testUser);
        Assertions.assertEquals(EXISTING_USER_NAME, testUser.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), testUser.getPassword());
        Assertions.assertEquals(2, testUserEntity.getRoles().size());
        Assertions.assertTrue(testUser.getRoles().contains(testUserRoleAdmin));

    }

    @Test
    void testUserNotFound() {
        assertThrows(UsernameNotFoundException.class,
                () -> {
                    toTest.getUser(NOT_EXISTING_USER_NAME);
                }
        );
    }

    @Test
    void registerUser() {
        UserRegisterFormDto userRegisterFormDto = new UserRegisterFormDto("ivo@hop.com", "wwwww", "wwwww", "Ivaylo", "on");
        when(passwordEncoder.encode(userRegisterFormDto.getPassword())).thenReturn("secret");
        UserRoleEntity testUserRoleAdmin = new UserRoleEntity();
        testUserRoleAdmin.setRole(UserRoleEnum.ADMIN);
        UserRoleEntity testUserRoleUser = new UserRoleEntity();
        testUserRoleUser.setRole(UserRoleEnum.USER);
        List<UserRoleEntity> roles = List.of(testUserRoleAdmin, testUserRoleUser);
        when(userRoleService.findUserRoleByRole(UserRoleEnum.USER)).thenReturn(testUserRoleUser);
        when(modelMapper.map(userRegisterFormDto, UserEntity.class)).thenReturn(new UserEntity(1L, "Ivaylo", "wwwww", "ivo@hop.com", "on", roles));

        toTest.registerUser(userRegisterFormDto);

        verify(mockUserRepository).save(userEntityArgumentCaptor.capture());

        UserEntity actualUser = userEntityArgumentCaptor.getValue();
        assertEquals(userRegisterFormDto.getEmail(), actualUser.getEmail());
        assertEquals("secret", actualUser.getPassword());
    }

}
