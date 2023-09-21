package pageObjectsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String userName = "academic198405@gmail.com";
    protected String password = "Te$t$tudent";
    protected String wrongpassword = "Te$t$tudents";
    @BeforeMethod

    public void starUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterMethod
    public  void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
