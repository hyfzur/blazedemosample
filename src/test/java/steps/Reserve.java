package steps;

import cucumberHook.Hooks;
import io.cucumber.java8.En;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import pageobjects.ReservePO;

public class Reserve implements En {
    private ReservePO reservePO;

    @Inject
    Hooks hooks;
    @Inject
    Home home;

    public Reserve() {
        Then("^User should be on the Reserve flight page$", () -> {
            reservePO = new ReservePO(hooks.driver);

            String expectedTitle = "Flights from " + home.depCity + " to " + home.desCity + ":";
            Assert.assertEquals(reservePO.getTitle(), expectedTitle, "Incorrect title on Reserve page,");
        });
        When("^User chooses flight number \"([^\"]*)\"$", (String flightNumber) -> {
            reservePO.selectFlightNumber(flightNumber);
        });
        When("^User chooses the first flight from \"([^\"]*)\" airline$", (String arg0) -> {
            reservePO.selectFirstFlightFromAirline("Virgin America");
        });
    }
}
