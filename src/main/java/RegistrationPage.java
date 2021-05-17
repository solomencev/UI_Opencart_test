import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstNameField = By.xpath("//*[@name='firstname']");
    By lastNameField = By.xpath("//*[@name='lastname']");
    By emailField = By.xpath("//*[@name='email']");
    By phoneField = By.xpath("//*[@name='telephone']");
    By passwordField1 = By.xpath("//*[@name='password']");
    By passwordField2 = By.xpath("//*[@name='confirm']");
    By subscribeYes = By.xpath("(//*[@type='radio'][@value='1'])[2]");
    By subscribeNo = By.xpath("//*[@type='radio'][@value='0']");
    By agreeCheckbox = By.xpath("//*[@name='agree']");
    By submitButton = By.xpath("//*[@type='submit']");
    By FirstNameFieldEmpty = By.xpath("//*[text()='First Name must be between 1 and 32 characters!']");
    By LastNameFieldEmpty = By.xpath("//*[text()='Last Name must be between 1 and 32 characters!']");
    By emailFieldEmpty = By.xpath("//*[text()='E-Mail Address does not appear to be valid!']");
    By phoneFieldEmpty = By.xpath("//*[text()='Telephone must be between 3 and 32 characters!']");
    By passwordFieldEmpty = By.xpath("//*[text()='Password must be between 4 and 20 characters!']");
    By warningPrivacyPolicy = By.xpath("//*[text()=' Warning: You must agree to the Privacy Policy!']");
    By differentPassword = By.xpath("//*[text()='Password confirmation does not match password!']");


    public AccountCreatedsuccess submit() {
        driver.findElement(submitButton).click();
        return new AccountCreatedsuccess(driver);
    }

    public AccountCreatedsuccess correctlyFillField(String fname, String lname, String email, String phone, String password1,
                                                    String password2) {
        driver.findElement(firstNameField).sendKeys(fname);
        driver.findElement(lastNameField).sendKeys(lname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(passwordField1).sendKeys(password1);
        driver.findElement(passwordField2).sendKeys(password2);
        driver.findElement(subscribeYes).click();
        driver.findElement(agreeCheckbox).click();
        driver.findElement(submitButton).click();
        return new AccountCreatedsuccess(driver);
    }

    public String FirstNameFieldEmpty() {
        return driver.findElement(FirstNameFieldEmpty).getText();
    }

    public String LastNameFieldEmpty() {
        return driver.findElement(LastNameFieldEmpty).getText();
    }

    public String emailFieldEmpty() {
        return driver.findElement(emailFieldEmpty).getText();
    }

    public String phoneFieldEmpty() {
        return driver.findElement(phoneFieldEmpty).getText();
    }

    public String passwordFieldEmpty() {
        return driver.findElement(passwordFieldEmpty).getText();
    }

    public String warningPrivacyPolicy() {
        return driver.findElement(warningPrivacyPolicy).getText();
    }
    public String differentPassword() {return  driver.findElement(differentPassword).getText();}

    public String[] allEmptyFields() {
        String[] list = {
                FirstNameFieldEmpty(), LastNameFieldEmpty(), emailFieldEmpty(), phoneFieldEmpty(), passwordFieldEmpty(),
                warningPrivacyPolicy(), differentPassword()
        };
        return list;
    }

    public Boolean radioButtonYesDefault() {
        return driver.findElement(subscribeYes).isSelected();
    }

    public Boolean radioButtonNoDefault() {
        return driver.findElement(subscribeNo).isEnabled();
    }

    public Boolean checkboxDefault() {
        return driver.findElement(agreeCheckbox).isSelected();
    }


}