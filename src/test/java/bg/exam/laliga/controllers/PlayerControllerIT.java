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
public class PlayerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toPlayers() throws Exception {
        mockMvc.perform(get("/players"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("players"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void allPlayers() throws Exception {
        mockMvc.perform(get("/players/all"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("players"))
                .andExpect(view().name("players"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void playerByName() throws Exception {
        String PLAYER_NAME = "Karim";
        mockMvc.perform(get("/players/" + PLAYER_NAME))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("player"))
                .andExpect(view().name("playerInfo"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void playerGoalsAndPasses() throws Exception {
        mockMvc.perform(get("/players/stats"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void allPlayersByTeam() throws Exception {
        String TEAM_NAME = "Real Madrid";
        mockMvc.perform(get("/players/byTeam/" + TEAM_NAME))
                .andExpect(status().is2xxSuccessful());
    }

}
