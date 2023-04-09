package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.entities.CoachEntity;
import bg.exam.laliga.services.CoachService;
import bg.exam.laliga.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CoachControllerIT {

    @Autowired
    private MockMvc mockMvc;
    private CoachEntity toTest;
    @Mock
    CoachService mockCoachService;

    @BeforeEach
    void setUp() {
        toTest = new CoachEntity();
        toTest.setName(COACH_FIRST_NAME);
        toTest.setLastName(COACH_LAST_NAME);
    }

    private final String COACH_FIRST_NAME = "Carlo";
    private final String COACH_LAST_NAME = "Ancelotti";

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void testGetCoach() throws Exception {
        mockMvc.perform(get("/coach/" + COACH_FIRST_NAME + " " + COACH_LAST_NAME))
                .andExpect(status().is2xxSuccessful());
    }

}
