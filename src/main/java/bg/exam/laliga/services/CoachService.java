package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.AddCoachFormDto;
import bg.exam.laliga.domain.entities.CoachEntity;
import bg.exam.laliga.domain.enums.PositionEnum;
import bg.exam.laliga.repositories.CoachRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    private final CoachRepository coachRepository;
    private final ModelMapper mapper;

    public CoachService(CoachRepository coachRepository, ModelMapper mapper) {
        this.coachRepository = coachRepository;
        this.mapper = mapper;
    }

    public void addNewCoach(AddCoachFormDto addCoachFormDto) {

        CoachEntity coachEntity = this.mapper.map(addCoachFormDto, CoachEntity.class);
        coachEntity.setPosition(PositionEnum.COACH.name());

        this.coachRepository.save(coachEntity);
    }

    public CoachEntity findCoachByNameAndLastName(String name, String lastName) {
        return this.coachRepository.findByNameAndLastName(name, lastName).orElseThrow();
    }

}
