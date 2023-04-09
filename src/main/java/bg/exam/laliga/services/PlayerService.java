package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.AddPlayerFormDto;
import bg.exam.laliga.domain.dto.PlayerGoalsAndPassesDto;
import bg.exam.laliga.domain.entities.BaseEntity;
import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public void addNewPlayer(AddPlayerFormDto playerFormDto) {

        PlayerEntity newPlayer = this.mapper.map(playerFormDto, PlayerEntity.class);

        this.playerRepository.save(newPlayer);
    }

    public List<String> allPlayersNames() {
        return this.playerRepository.findAll().stream().map(BaseEntity::getName).toList();
    }

    public PlayerEntity getPlayerByName(String name) {
        return this.playerRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Player with " + name + " not found in the database!"));
    }

    public List<PlayerEntity> allPlayersByTeam(String teamName) {
        return this.playerRepository.findAllByTeamName(teamName);
    }

}
