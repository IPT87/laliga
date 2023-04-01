package bg.exam.laliga.services;

import bg.exam.laliga.domain.dto.AddStadiumFormDto;
import bg.exam.laliga.domain.entities.StadiumEntity;
import bg.exam.laliga.repositories.StadiumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final ModelMapper mapper;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository, ModelMapper mapper) {
        this.stadiumRepository = stadiumRepository;
        this.mapper = mapper;
    }

    public void addNewStadium(AddStadiumFormDto addStadiumFormDto) {

        StadiumEntity stadiumEntity = this.mapper.map(addStadiumFormDto, StadiumEntity.class);

        this.stadiumRepository.save(stadiumEntity);

    }

}
