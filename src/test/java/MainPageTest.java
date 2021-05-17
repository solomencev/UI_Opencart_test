import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private UserPage userPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        mainPage = new MainPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    public void TestsignInCorrectCredential(){
        mainPage.typeUserEmail("exjfizhh@firste.ml");
        mainPage.typeUserPassword("admin");
        mainPage.submit();
        String tag = userPage.getTagAccount();
        Assert.assertEquals("My Account", tag);
    }

    @Test
    public void TestsignInWrongCredential(){
        mainPage.typeWrongCreds("Login", "Password");
        String tag = mainPage.errorMessage();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", tag);
    }

    @Test
    public void TestsignInCorrectEmail(){
        mainPage.typeWrongCreds("exjfizhh@firste.ml", "password");
        String tag = mainPage.errorMessage();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", tag);
    }

    @Test
    public void TestsignInCorrectPassword(){
        mainPage.typeWrongCreds("test@gmail.com", "admin");
        String tag = mainPage.errorMessage();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", tag);
    }

    @Test
    public void TestsignInEmptyFields(){
        mainPage.typeWrongCreds("", "");
        String tag = mainPage.errorMessage();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", tag);
    }




    @After
    public void tearDown(){
        driver.quit();
        }


}
