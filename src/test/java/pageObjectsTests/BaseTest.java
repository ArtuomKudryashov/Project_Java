package pageObjectsTests;

import enums.BrowserType;
import helpers.BrowserFactory;
import listeners.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected String  username;
    protected String password ;
    protected String wrongpassword;
    @Parameters({"username","password","wrongpassword","browser"})
    @BeforeMethod
    public void starUp(String email,String password, String wrongpassword, String browser){
        username = email;
        this.password = password;
        this.wrongpassword = wrongpassword;

        BrowserType browserType = browser.equals("chrome")? BrowserType.CHROME : BrowserType.FIREFOX;
        driver = BrowserFactory.getDriver(browserType);



    }



    @AfterMethod
    public  void tearDown(ITestResult iTestResult)throws InterruptedException{
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());

        }
        Thread.sleep(3000);
        driver.quit();
    }
}
