package steps;

import cucumberHook.Hooks;
import io.cucumber.java8.En;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import pageobjects.ConfirmationPO;

public class Confirmation implements En {
    private ConfirmationPO confirmationPO;

    @Inject
    Hooks hooks;

    public Confirmation() {
        Then("^User should be on the Flight confirmation page$", () -> {
            confirmationPO = new ConfirmationPO(hooks.driver);

            String expectedTitle = "Thank you for your purchase today!";
            Assert.assertEquals(confirmationPO.getTitle(), expectedTitle, "Incorrect title on Confirmation page,");
        });
    }
}
