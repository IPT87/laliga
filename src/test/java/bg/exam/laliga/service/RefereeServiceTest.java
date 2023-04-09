package bg.exam.laliga.service;

import bg.exam.laliga.domain.dto.AddRefereeFormDto;
import bg.exam.laliga.domain.entities.RefereeEntity;
import bg.exam.laliga.repositories.RefereeRepository;
import bg.exam.laliga.services.RefereeService;
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
public class RefereeServiceTest {

    RefereeService toTest;
    @Mock
    private RefereeRepository refereeRepository;
    @Mock
    private ModelMapper mapper;
    @Captor
    private ArgumentCaptor<RefereeEntity> refereeEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        toTest = new RefereeService(refereeRepository, mapper);
    }

    @Test
    void addNewReferee() {
        AddRefereeFormDto addRefereeFormDto = new AddRefereeFormDto("David", "Bisbal", "21-09-1984", "Pleven", "Referee", "afafaffss", "asasfaff", "11-11-2011", "12-12-2012");
        RefereeEntity refereeEntity = new RefereeEntity("11-11-2011", "12-12-2012");

        when(mapper.map(addRefereeFormDto, RefereeEntity.class)).thenReturn(refereeEntity);

        toTest.addNewReferee(addRefereeFormDto);

        verify(refereeRepository).save(refereeEntityArgumentCaptor.capture());

        RefereeEntity actualReferee = refereeEntityArgumentCaptor.getValue();
        assertEquals(addRefereeFormDto.getLaLigaDebut(), actualReferee.getLaLigaDebut());

    }

}
