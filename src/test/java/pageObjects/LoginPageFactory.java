package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {
    private WebDriver driver;
    private String url =  "https://qa.koel.app/";


    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @FindBy(css = "[type='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@type = 'password']")
    private WebElement password;


    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(className = "error")
    private WebElement error;



    public void open(String url) {
        driver.get(this.url);
    }

    public boolean isErrorFrame() {
        try {
            return error.isDisplayed();

        } catch (TimeoutException err) {
            return false;
        }


    }
    public MainPage loginToApp(String usernameInput, String passwordInput) {
        email.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginButton.click();
        return new MainPage(driver);
    }


}
