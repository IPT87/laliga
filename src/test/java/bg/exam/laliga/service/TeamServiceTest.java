package bg.exam.laliga.service;


import bg.exam.laliga.domain.dto.AddTeamFormDto;
import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.domain.entities.TeamEntity;
import bg.exam.laliga.repositories.TeamRepository;
import bg.exam.laliga.services.PlayerService;
import bg.exam.laliga.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    TeamService toTest;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private PlayerService playerService;
    @Mock
    private ModelMapper mapper;
    @Captor
    private ArgumentCaptor<TeamEntity> teamEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new TeamService(teamRepository, playerService, mapper);
    }

    @Test
    void addNewTeam() {
        List<String> players = List.of("Benzema", "Kroos", "Marcelo");
        AddTeamFormDto addTeamFormDto = new AddTeamFormDto("1959", "Ben Aflek", "Real Madrid", "www.rm-fc.com",
                "asedsrtf", "Tom Cruse", "Santiago Bernabeu", "aswdesrs", 1,
                1, 1, 1, 1, 1, players);
        PlayerEntity playerEntity = new PlayerEntity(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Levski", "asedfret", 1);
        TeamEntity teamEntity = new TeamEntity(1L, "1959", "Ben Aflek", "Real Madrid", "www.rm-fc.com",
                "asedsrtf", "Tom Cruse", "Santiago Bernabeu", "aswdesrs", 1,
                1, 1, 1, 1, 1, List.of(playerEntity));

        when(mapper.map(addTeamFormDto, TeamEntity.class)).thenReturn(teamEntity);

        toTest.addNewTeam(addTeamFormDto);

        verify(teamRepository).save(teamEntityArgumentCaptor.capture());

        TeamEntity actualTeam = teamEntityArgumentCaptor.getValue();
        assertEquals(addTeamFormDto.getYearOfFoundation(), actualTeam.getYearOfFoundation());
        assertEquals(addTeamFormDto.getPresident(), actualTeam.getPresident());
        assertEquals(addTeamFormDto.getMatchesPlayed(), actualTeam.getMatchesPlayed());
        assertEquals(addTeamFormDto.getMatchesToPlay(), actualTeam.getMatchesToPlay());
        assertEquals(addTeamFormDto.getWins(), actualTeam.getWins());
        assertEquals(addTeamFormDto.getDraws(), actualTeam.getDraws());
        assertEquals(addTeamFormDto.getLoses(), actualTeam.getLoses());
        assertEquals(addTeamFormDto.getPoints(), actualTeam.getPoints());

    }

}
