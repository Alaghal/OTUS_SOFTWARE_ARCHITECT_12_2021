//package otus.seryakov.myapp.story;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.JUnitRestDocumentation;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import otus.seryakov.myapp.MyappApplication;
//import otus.seryakov.myapp.service.UserService;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ActiveProfiles("test")
//@SpringBootTest(classes = MyappApplication.class)
//@Testcontainers
//@AutoConfigureMockMvc
//@DirtiesContext
//class UserControllerTest {
//
//
//    @Rule
//    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
//
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private UserService service;
//
//    @Autowired
//    private MockMvc mockMvc;
//
////    @Before
////    public void setUp() {
////        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
////                .apply(documentationConfiguration(this.restDocumentation)).build();
////    }
//
//
//
//
//
//    @Test
//    void contextLoads() {
//    }
//
//
//    @Test
//     void getUsers() throws Exception {
//        mockMvc.perform(get("/v1/users")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
//}
