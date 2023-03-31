package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.TeamStandingsDto;
import bg.exam.laliga.domain.entities.TeamEntity;
import bg.exam.laliga.repositories.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    @Autowired
    public TeamService(TeamRepository teamRepository, ModelMapper mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    public List<TeamStandingsDto> getTeamsStandings() {
        return map(this.teamRepository.findAll());
    }

    private List<TeamStandingsDto> map(List<TeamEntity> teamEntityList) {
        return teamEntityList.stream().map(t -> mapper.map(t, TeamStandingsDto.class)).toList();
    }

}
