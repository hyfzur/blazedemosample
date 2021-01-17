package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ReservePO {

    public ReservePO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3")
    private WebElement title_txt;
    @FindBy(css = "table tr")
    List<WebElement> flightsList;

    public String getTitle() {
        return title_txt.getText();
    }

    public void selectFlightNumber(String flightNumber) {
        flightsList.stream()
                .skip(1)
                .filter(element -> element.findElement(By.cssSelector("td:nth-child(3)")).getText().equalsIgnoreCase(flightNumber))
                .map(element -> element.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }

    public void selectFirstFlightFromAirline(String airlineName) {
        try {
            flightsList.stream()
                    .skip(1)
                    .filter(element -> element.findElement(By.cssSelector("td:nth-child(4)")).getText().equalsIgnoreCase(airlineName))
                    .map(element -> element.findElement(By.tagName("input")))
                    .findFirst().orElseThrow(Exception::new).click();
        } catch (Exception e) {
            System.out.println("There are no flights from " + airlineName);
        }
    }
}
