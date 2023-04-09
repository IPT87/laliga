package bg.exam.laliga.service;

import bg.exam.laliga.domain.dto.AddPlayerFormDto;
import bg.exam.laliga.domain.dto.UserRegisterFormDto;
import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.entities.UserRoleEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.repositories.PlayerRepository;
import bg.exam.laliga.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    private final String PLAYER_NAME = "Benzema";

    PlayerService toTest;

    @Mock
    PlayerRepository mockPlayerRepository;
    @Mock
    PlayerEntity playerEntity;
    @Mock
    ModelMapper mapper;
    @Captor
    ArgumentCaptor<PlayerEntity> playerEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new PlayerService(mockPlayerRepository, mapper);
        playerEntity = new PlayerEntity();
        playerEntity.setName("Benzema");
    }

    @Test
    void testGetPlayerByName() {

        when(mockPlayerRepository.findByName(any())).thenThrow(UsernameNotFoundException.class);

        assertThrows(UsernameNotFoundException.class,
                () -> {
                    mockPlayerRepository.findByName(PLAYER_NAME);
                }
        );

    }

    @Test
    void getPlayerByName() {

        assertEquals("Benzema", playerEntity.getName());

    }

    @Test
    void addNewPlayer() {
        AddPlayerFormDto addPlayerFormDto = new AddPlayerFormDto("David", "Philips", "1999", "Madrid", "Forward", "swdeasdr", "asdadsda",
                86, 185, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, "Real Madrid", "aswedsls", 1);
        PlayerEntity playerEntity1 = new PlayerEntity(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Real Madrid", "sfsdfsff", 1);

        when(mapper.map(addPlayerFormDto, PlayerEntity.class)).thenReturn(playerEntity1);

        toTest.addNewPlayer(addPlayerFormDto);

        verify(mockPlayerRepository).save(playerEntityArgumentCaptor.capture());

        PlayerEntity actualPlayer = playerEntityArgumentCaptor.getValue();
        assertEquals(addPlayerFormDto.getTeamName(), actualPlayer.getTeamName());

    }

}
