package otus.seryakov.myapp.story;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import otus.seryakov.myapp.MyappApplication;
import otus.seryakov.myapp.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(classes = MyappApplication.class)
@AutoConfigureMockMvc
@Testcontainers
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
    }


    @Test
     void getUsers() throws Exception {
        mvc.perform(get("/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
