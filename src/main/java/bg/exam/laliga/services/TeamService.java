package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.AddTeamFormDto;
import bg.exam.laliga.domain.dto.TeamStandingsDto;
import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.domain.entities.TeamEntity;
import bg.exam.laliga.repositories.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerService playerService;
    private final ModelMapper mapper;

    @Autowired
    public TeamService(TeamRepository teamRepository, PlayerService playerService, ModelMapper mapper) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
        this.mapper = mapper;
    }

    public List<TeamStandingsDto> getTeamsStandings() {
        return map(this.teamRepository.findAll());
    }

    public void addNewTeam(AddTeamFormDto addTeamFormDto) {


        TeamEntity teamEntity = this.mapper.map(addTeamFormDto, TeamEntity.class);
        List<PlayerEntity> players = new ArrayList<>();

        addTeamFormDto.getPlayers().forEach(p -> players.add(this.playerService.getPlayerByName(p)));
        teamEntity.setPlayers(players);

        this.teamRepository.save(teamEntity);

    }

    private List<TeamStandingsDto> map(List<TeamEntity> teamEntityList) {
        return teamEntityList.stream().map(t -> mapper.map(t, TeamStandingsDto.class)).toList();
    }

}
