package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.AddRefereeFormDto;
import bg.exam.laliga.domain.entities.RefereeEntity;
import bg.exam.laliga.domain.enums.PositionEnum;
import bg.exam.laliga.repositories.RefereeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RefereeService {

    private final RefereeRepository refereeRepository;
    private final ModelMapper mapper;

    public RefereeService(RefereeRepository refereeRepository, ModelMapper mapper) {
        this.refereeRepository = refereeRepository;
        this.mapper = mapper;
    }

    public void addNewReferee(AddRefereeFormDto addRefereeFormDto) {
        RefereeEntity refereeEntity = this.mapper.map(addRefereeFormDto, RefereeEntity.class);
        refereeEntity.setPosition(PositionEnum.REFEREE.name());

        this.refereeRepository.save(refereeEntity);
    }

}
