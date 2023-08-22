package experienced.dev.javastartertemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TemplateController.class)
class TemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthCheck() throws Exception {
        mockMvc.perform(get("/healthz"))
                .andExpectAll(status().isOk()); // HTTP_OK = 200
    }

    @Test
    void readyCheck() throws Exception {
        mockMvc.perform(get("/readyz"))
                .andExpectAll(status().isOk()); // HTTP_OK = 200
    }
}
