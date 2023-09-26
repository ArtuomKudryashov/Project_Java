package PageObjectsTest;

import enums.BrowserType;
import helpers.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        driver = BrowserFactory.getDriver(BrowserType.EDGE);

//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        driver = new ChromeDriver();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        WebDriverManager.operadriver().setup();
//        driver = new OperaDriver();
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();


    }

    @AfterMethod
    public  void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
