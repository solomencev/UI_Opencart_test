import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedsuccess {

    private WebDriver driver;

    public AccountCreatedsuccess(WebDriver driver) {
        this.driver = driver;
    }

    By tagSuccess = By.xpath("//*[text()='Success']");

    public String congratulation(){
        return driver.findElement(tagSuccess).getText();

    }


}
