package PageObjectsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String userName ;
    protected String password ;
    protected String wrongpassword;
    @BeforeMethod

    public void starUp(){
        userName = "academic198405@gmail.com";
        password = "te$t$tudent";
        wrongpassword = "te$t$tudents";

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterMethod
    public  void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
