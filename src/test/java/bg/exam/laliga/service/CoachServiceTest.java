package bg.exam.laliga.service;

import bg.exam.laliga.domain.dto.AddCoachFormDto;
import bg.exam.laliga.domain.entities.CoachEntity;
import bg.exam.laliga.repositories.CoachRepository;
import bg.exam.laliga.services.CoachService;
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
public class CoachServiceTest {

    private CoachService toTest;
    @Mock
    private CoachRepository coachRepository;
    @Mock
    private ModelMapper modelMapper;
    @Captor
    private ArgumentCaptor<CoachEntity> coachEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new CoachService(coachRepository, modelMapper);
    }

    @Test
    void addNewCoach() {
        AddCoachFormDto addCoachFormDto = new AddCoachFormDto("Carlo", "Ancelotti", "25-11-1956", "Milan", "Coach", "asdasdcd", "adsadasd");
        CoachEntity coachEntity = new CoachEntity();
        coachEntity.setName("Carlo");
        coachEntity.setLastName("Ancelotti");
        coachEntity.setPosition("Coach");
        coachEntity.setFlagUrl("dsfsdfdf");
        coachEntity.setPhotoUrl("afafaff");
        coachEntity.setPlaceOfBirth("Milan");
        coachEntity.setDateOfBirth("25-11-1956");

        when(modelMapper.map(addCoachFormDto, CoachEntity.class)).thenReturn(coachEntity);

        toTest.addNewCoach(addCoachFormDto);

        verify(coachRepository).save(coachEntityArgumentCaptor.capture());

        CoachEntity actualCoach = coachEntityArgumentCaptor.getValue();
        assertEquals(addCoachFormDto.getName(), actualCoach.getName());

    }

}
