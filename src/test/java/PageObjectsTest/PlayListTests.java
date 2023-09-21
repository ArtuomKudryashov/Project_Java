package PageObjectsTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.MainPage;

public class PlayListTests extends  BaseTest {
    private WebDriver driver;

    @Test
    public void playlistTests_createPlaylist_playlistCreated() {
        Faker faker = new Faker();
//        String playlistName = TestDataGenerator.getString(7);
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(userName,password);
        String playlistId=mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId,playlistName));


    }
}
