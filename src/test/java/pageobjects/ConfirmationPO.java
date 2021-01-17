package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPO {

    public ConfirmationPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement title_txt;

    public String getTitle() {
        return title_txt.getText();
    }
}
