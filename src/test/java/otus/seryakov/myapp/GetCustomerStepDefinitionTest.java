package otus.seryakov.myapp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
@SpringBootTest(classes = MyappApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@DirtiesContext( classMode = DirtiesContext.ClassMode.AFTER_CLASS )
@CucumberContextConfiguration
@Testcontainers
@Profile("test")
@ActiveProfiles("test")
public class GetCustomerStepDefinitionTest  {

	private Response response;
	private String api;

	@LocalServerPort
	private int port;

	@Given("we have contrell with api {string}")
	public void we_have_contrell_with_api(String api) {
		this.api = api;
	}

	@When("the client calls GET for api")
	public void the_client_calls_get_for_api() {
		response = given().port(port).when().get(api);
	}

	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(int status) {
		assertThat("Response status",status,is(response.getStatusCode()));
	}

}