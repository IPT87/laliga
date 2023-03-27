package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.PlayerGoalsAndPassesDto;
import bg.exam.laliga.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper mapper;

    public PlayerService(PlayerRepository playerRepository, ModelMapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    public List<PlayerGoalsAndPassesDto> playerGoalsAndPassesDtoList() {
        return this.playerRepository.findAll().stream().map(p -> mapper.map(p, PlayerGoalsAndPassesDto.class)).toList();
    }

}
