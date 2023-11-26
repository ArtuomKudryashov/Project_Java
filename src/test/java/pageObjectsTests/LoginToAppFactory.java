package pageObjectsTests;

import pageObjects.LoginPageFactory;
import pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToAppFactory extends BaseTest {

    @Test
    public void loginToApp_correctCredentials_successfulLogin(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginToApp_incorrectCredentials_failedLogin(){
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username, wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
    @Test
    public void loginToApp_correctCredentials_successfulLogin1(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_successfulLogin1(){
        LoginPageFactory loginPage = new  LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username,wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
    @Test
    public void loginToApp_correctCredentials_successfulLogin2(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_successfulLogin2(){
        LoginPageFactory loginPage = new  LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username,wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
    @Test
    public void loginToApp_correctCredentials_successfulLogin3(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_successfulLogin3(){
        LoginPageFactory loginPage = new  LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username,wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
    @Test
    public void loginToApp_correctCredentials_successfulLogin4(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_successfulLogin4(){
        LoginPageFactory loginPage = new  LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username,wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }
    @Test
    public void loginToApp_correctCredentials_successfulLogin5(){
        LoginPageFactory loginPage = new LoginPageFactory (driver);
        loginPage.open("https://qa.koel.app/");
        MainPage mainPage=loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_successfulLogin5(){
        LoginPageFactory loginPage = new  LoginPageFactory(driver);
        loginPage.open("https://qa.koel.app/");
        loginPage.loginToApp(username,wrongpassword);
        Assert.assertTrue(loginPage.isErrorFrame());
    }

}
