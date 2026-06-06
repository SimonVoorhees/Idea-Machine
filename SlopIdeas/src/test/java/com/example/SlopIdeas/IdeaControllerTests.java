package com.example.SlopIdeas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class IdeaControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public IdeaController ideaController() {

        return new IdeaController(new IdeaService());
    }

    @Test
    public void getDefault() throws Exception {
        mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getRandom() throws Exception {
        mvc.perform(get("/8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
