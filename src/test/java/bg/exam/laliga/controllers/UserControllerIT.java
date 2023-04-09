package bg.exam.laliga.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void getUserById() throws Exception {
        String USERNAME_TO_FIND = "Ivo";
        mockMvc.perform(get("/users/user/" + USERNAME_TO_FIND))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("currentRoles"))
                .andExpect(model().attributeExists("allRoles"))
                .andExpect(model().attributeExists("userToModify"))
                .andExpect(view().name("modifyUser"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void testAllUsers() throws Exception {
        mockMvc.perform(get("/users/all"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("allUsers"))
                .andExpect(view().name("users"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void testDeleteUser() throws Exception {
        String USERNAME = "Ivaylo";
        mockMvc.perform(get("/users/delete/" + USERNAME))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("allUsers"))
                .andExpect(view().name("users"));
    }

    @Test
    @WithMockUser(username = "Ivaylo", roles = {"ADMIN"})
    void modifyUser() throws Exception {
        mockMvc.perform(post("/userModify"))
                .andExpect(status().is4xxClientError());
    }

}
