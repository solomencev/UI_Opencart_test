import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private AccountCreatedsuccess accountCreatedsuccess;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        registrationPage = new RegistrationPage(driver);
        accountCreatedsuccess = new AccountCreatedsuccess(driver);
    }

    @Test
    public void TestcorrectRegistration() {
        registrationPage.correctlyFillField("test", "test", "d24f110356vb@gmail.com", "035412", "Qwerty1!", "Qwerty1!");
        String tag = accountCreatedsuccess.congratulation();
        Assert.assertEquals("Success", tag);
    }

    @Test
    public void TestsubmitEmptyField() {
        registrationPage.submit();
        String[] errorMessage = registrationPage.allEmptyFields();
        Assert.assertEquals("First Name must be between 1 and 32 characters!", errorMessage[0]);
    }

    @Test
    public void TestradioButtonYesDefault() {
        Boolean yes = registrationPage.radioButtonYesDefault();
        Assert.assertEquals(false, yes);

    }

    @Test
    public void TestRadioButtonNoDefault() {
        Boolean no = registrationPage.radioButtonNoDefault();
        Assert.assertEquals(true, no);

    }

    @Test
    public void TestCheckboxDefault() {
        Boolean checkbox = registrationPage.checkboxDefault();
        Assert.assertEquals(false, checkbox);
    }

    @Test
    public void TestSamePassword() {
        registrationPage.correctlyFillField("Test", "Test", "Tdv@gmil.com", "5664",
                "Qwerty", "Qwert");
        Assert.assertEquals("Password confirmation does not match password!", registrationPage.differentPassword());
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}
