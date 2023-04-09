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
public class TeamControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toLeaderBoard() throws Exception {
        mockMvc.perform(get("/teams"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("standingsTable"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void standings() throws Exception {
        mockMvc.perform(get("/teams/standings"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void teamInfo() throws Exception {
        String TEAM_NAME = "Real Madrid";
        mockMvc.perform(get("/teams/info/" + TEAM_NAME))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("team"))
                .andExpect(view().name("team"));
    }

}
