package PageObjectsTest;

import PageObjects.LoginPage;
import PageObjects.LoginPageFactory;
import PageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToAppFactory extends BaseTest {

    @Test
    public void loginToApp_correctCredentials_successfulLogin(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(userName,password);
        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginToApp_incorrectCredentials_failedLogin(){
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(userName, wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
}
