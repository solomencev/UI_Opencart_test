import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }
    By emailField = By.xpath("//*[@name='email']");
    By passwordField = By.xpath("//*[@name='password']");
    By submitButton = By.xpath("//*[@type='submit']");
    By ErrorMessage = By.xpath("//*[text()=' Warning: No match for E-Mail Address and/or Password.']");

    public UserPage submit(){
        driver.findElement(submitButton);
        return new UserPage(driver);
    }

    public MainPage typeUserEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage typeUserPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeWrongCreds(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return this;
    }

    public String errorMessage(){
        return driver.findElement(ErrorMessage).getText();

    }

}
