package steps;

import cucumberHook.Hooks;
import io.cucumber.java8.En;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import pageobjects.PurchasePO;

public class Purchase implements En {
    private PurchasePO purchasePO;

    @Inject
    Hooks hooks;

    public Purchase() {
        Then("^User should be on the Purchase flight page$", () -> {
            purchasePO = new PurchasePO(hooks.driver);

            String expectedTitle = "Your flight from TLV to SFO has been reserved.";
            Assert.assertEquals(purchasePO.getTitle(), expectedTitle, "Incorrect title on Purchase page,");
        });
        When("^User enters the passenger and card details$", () -> {
            purchasePO.enterName("Hifzur Rahman");
            purchasePO.enterAddress("Park Street");
            purchasePO.enterCity("Kolkata");
            purchasePO.enterState("West Bengal");
            purchasePO.enterZip("700016");
            purchasePO.enterCreditCardNumber("444455550000XXXX");
            purchasePO.enterCreditCardMonth("12");
            purchasePO.enterCreditCardYear("2027");
            purchasePO.enterNameOnCard("Hifzur Rahman");
        });
        And("^User clicks on the Purchase Flight button$", () -> {
            purchasePO.clickPurchaseFlight();
            Thread.sleep(3000);
        });
    }
}
