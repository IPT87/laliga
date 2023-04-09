package bg.exam.laliga.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StadiumControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toStadium() throws Exception {
        mockMvc.perform(get("/stadiums"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("stadiums"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void allStadiums() throws Exception {
        mockMvc.perform(get("/stadiums/all"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void stadiumById() throws Exception {
        String STADIUM_NAME = "Mestalla";
        mockMvc.perform(get("/stadiums/" + STADIUM_NAME))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("stadium"))
                .andExpect(view().name("stadiumInfo"));
    }

}
