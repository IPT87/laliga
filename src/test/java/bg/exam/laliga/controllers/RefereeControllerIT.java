package bg.exam.laliga.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@AutoConfigureMockMvc
public class RefereeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void toReferees() throws Exception {
        mockMvc.perform(get("/referees"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("referees"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void allReferees() throws Exception {
        mockMvc.perform(get("/referees/all"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("referees"))
                .andExpect(view().name("referees"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void refereeByName() throws Exception {
        String REFEREE_NAME = "Mateu";
        mockMvc.perform(get("/referees/" + REFEREE_NAME))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("referee"))
                .andExpect(view().name("refereeInfo"));
    }

}
