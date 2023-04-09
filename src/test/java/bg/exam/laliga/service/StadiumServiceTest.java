package bg.exam.laliga.service;

import bg.exam.laliga.domain.dto.AddStadiumFormDto;
import bg.exam.laliga.domain.entities.StadiumEntity;
import bg.exam.laliga.repositories.StadiumRepository;
import bg.exam.laliga.services.StadiumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StadiumServiceTest {

    StadiumService toTest;
    @Mock
    private StadiumRepository stadiumRepository;
    @Mock
    private ModelMapper mapper;
    @Captor
    private ArgumentCaptor<StadiumEntity> stadiumEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new StadiumService(stadiumRepository, mapper);
    }

    @Test
    void addNewStadium() {
        AddStadiumFormDto addStadiumFormDto = new AddStadiumFormDto("Santiago Bernabeu", "Madrid", "1976", 120000, "asafasffaefaefafaefaefafaf", "asfafaffff");
        StadiumEntity stadiumEntity = new StadiumEntity(1L, "Santiago Bernabeu", "Madrid", "1976", 120000, "asdaarararwarawrwrwrwr", "ssssssss");

        when(mapper.map(addStadiumFormDto, StadiumEntity.class)).thenReturn(stadiumEntity);

        toTest.addNewStadium(addStadiumFormDto);

        verify(stadiumRepository).save(stadiumEntityArgumentCaptor.capture());

        StadiumEntity actualStadium = stadiumEntityArgumentCaptor.getValue();
        assertEquals(addStadiumFormDto.getCity(), actualStadium.getCity());

    }

}
