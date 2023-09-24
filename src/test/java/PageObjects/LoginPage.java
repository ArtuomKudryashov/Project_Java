package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    private WebElement getEmailField() {
//        By emailBy = By.xpath("//*[@type='email']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy));
//        return driver.findElement(emailBy);
//
//    }
    private WebElement getEmailField() {
        By emailBy = By.xpath("//*[@type='email']");
        for (int i = 0; i < 10; i++) {
            try {
                WebElement email = driver.findElement(emailBy);
                return  email;
            } catch (NoSuchElementException ee) {
                try {
                    Thread.sleep(200);
                }catch (InterruptedException xx){}
            }
        }
        throw new TimeoutException("No such element");
    }


    private WebElement getPasswordField(){
        return driver.findElement(By.xpath("//*[@type='password']"));
    }


    private WebElement getLoginButton(){
        return  driver.findElement(By.tagName("button"));
    }


    public MainPage loginToApp(String username, String password) {
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }


    public  void open(){
        driver.get("https://qa.koel.app/");
    }
    public boolean isError(){
        By errorBy = By.className("error");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorBy));
            return  true;
        }catch (TimeoutException err){
            return  false;
        }
    }

}
