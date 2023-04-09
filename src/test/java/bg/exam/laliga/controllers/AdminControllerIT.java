package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.AddPlayerFormDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAddPlayer() throws Exception {
        mockMvc.perform(get("/administrationPanel/addPlayer"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("allPositions"))
                .andExpect(view().name("addPlayer"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void addPlayer() throws Exception {
        mockMvc.perform(post("/administrationPanel/addPlayer"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAddTeam() throws Exception {
        mockMvc.perform(get("/administrationPanel/addTeam"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("allPlayers"))
                .andExpect(view().name("addTeam"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAdminPanel() throws Exception {
        mockMvc.perform(get("/administrationPanel"))
                .andExpect(view().name("administrationPanel"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAddStadium() throws Exception {
        mockMvc.perform(get("/administrationPanel/addStadium"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addStadium"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAddCoach() throws Exception {
        mockMvc.perform(get("/administrationPanel/addCoach"))
                .andExpect(view().name("addCoach"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toAddReferee() throws Exception {
        mockMvc.perform(get("/administrationPanel/addReferee"))
                .andExpect(view().name("addReferee"));
    }

    @Test
    @WithMockUser(username = "Ivaylo")
    void toAdminPanelError() throws Exception {
        mockMvc.perform(get("/administrationPanel"))
                .andExpect(status().is4xxClientError());
    }

}
