package konsalting.t1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String startString = "aaaaabcccc";
    private String finalString = "\"a\": 5, \"c\": 4, \"b\": 1";

    @Test
    void metod() throws Exception {
        mockMvc.perform(post("/str")
                        .queryParam("s",startString))
                .andExpect(status().isOk())
                .equals(finalString);
    }
}
