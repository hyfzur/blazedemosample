package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePO {

    public HomePO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement title_txt;
    @FindBy(name = "fromPort")
    private WebElement departureCity_drpdwn;
    @FindBy(name = "toPort")
    private WebElement destinationCity_drpdwn;
    @FindBy(tagName = "input")
    private WebElement findFlights_btn;

    public String getTitle() {
        return title_txt.getText();
    }

    public void selectDepartureCity(String depCity) {
        new Select(departureCity_drpdwn).selectByVisibleText(depCity);
    }

    public void selectDestinationCity(String desCity) {
        new Select(destinationCity_drpdwn).selectByVisibleText(desCity);
    }

    public void clickFindFlights() {
        findFlights_btn.click();
    }
}
