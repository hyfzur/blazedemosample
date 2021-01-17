package steps;

import cucumberHook.Hooks;
import io.cucumber.java8.En;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import pageobjects.HomePO;

public class Home implements En {

    private HomePO homePO;
    public String depCity, desCity;

    @Inject
    Hooks hooks;

    public Home() {
        Given("^User is on the Blazedemo home page$", () -> {
            hooks.driver.get("https://blazedemo.com/");
            homePO = new HomePO(hooks.driver);

            String expectedTitle = "Welcome to the Simple Travel Agency!";
            Assert.assertEquals(expectedTitle, homePO.getTitle(), "Incorrect title on Home page,");
        });
        When("^User selects the Departure City as \"([^\"]*)\" and the Destination City as \"([^\"]*)\"$", (String depCity, String desCity) -> {
            this.depCity = depCity;
            this.desCity = desCity;
            homePO.selectDepartureCity(depCity);
            homePO.selectDestinationCity(desCity);
        });
        And("^User clicks on the Find Flights button$", () -> {
            homePO.clickFindFlights();
        });
    }
}
