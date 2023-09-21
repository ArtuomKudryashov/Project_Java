package PageObjectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.MainPage;

public class LoginToApp extends BaseTest {

    @Test
    public void loginToApp_correctCredentials_successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage= loginPage.loginToApp(userName, password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_failedLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApp(userName, wrongpassword);
        Assert.assertTrue(loginPage.isError());
    }
}
