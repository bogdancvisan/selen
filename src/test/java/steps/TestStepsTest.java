package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/gecko"
		,glue={"stepDefinition"}
		)

public class TestStepsTest
{

    public TestStepsTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

}
