import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    By myAccount = By.xpath("(//*[text()='My Account'])[4]");
    By myOrders = By.xpath("//*[text()='My Orders']");

    public String getTagAccount() {
        return driver.findElement(myAccount).getText();
    }
}
