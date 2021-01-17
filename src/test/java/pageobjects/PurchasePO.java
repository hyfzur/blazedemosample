package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePO {

    public PurchasePO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    private WebElement title_txt;
    @FindBy(id = "inputName")
    private WebElement name_inp;
    @FindBy(id = "address")
    private WebElement addr_inp;
    @FindBy(id = "city")
    private WebElement city_inp;
    @FindBy(id = "state")
    private WebElement state_inp;
    @FindBy(id = "zipCode")
    private WebElement zip_inp;
    @FindBy(id = "cardType")
    private WebElement cardType_drn;
    @FindBy(id = "creditCardNumber")
    private WebElement ccNum_inp;
    @FindBy(id = "creditCardMonth")
    private WebElement ccMon_inp;
    @FindBy(id = "creditCardYear")
    private WebElement ccYr_inp;
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard_inp;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement purchaseFlight_btn;

    public String getTitle() {
        return title_txt.getText();
    }

    public void enterName(String firstAndLastName) {
        name_inp.sendKeys(firstAndLastName);
    }

    public void enterAddress(String address) {
        addr_inp.sendKeys(address);
    }

    public void enterCity(String city) {
        city_inp.sendKeys(city);
    }

    public void enterState(String state) {
        state_inp.sendKeys(state);
    }

    public void enterZip(String zip) {
        zip_inp.sendKeys(zip);
    }

    public void selectCardType(String cardType) {
        new Select(cardType_drn).selectByVisibleText(cardType);
    }

    public void enterCreditCardNumber(String ccNumber) {
        ccNum_inp.sendKeys(ccNumber);
    }

    public void enterCreditCardMonth(String ccMonth) {
        ccMon_inp.sendKeys(ccMonth);
    }

    public void enterCreditCardYear(String ccYr) {
        ccYr_inp.sendKeys(ccYr);
    }

    public void enterNameOnCard(String name) {
        nameOnCard_inp.sendKeys(name);
    }

    public void clickPurchaseFlight() {
        purchaseFlight_btn.click();
    }
}
