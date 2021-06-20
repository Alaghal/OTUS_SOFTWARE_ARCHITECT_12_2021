package otus.seryakov.myapp;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;


@RunWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "otus.seryakov.myapp",
        plugin = {
                "html:/output/report.html" }, monochrome = true
)
public class RunnerTest {
}