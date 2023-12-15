package pageObjectsTests;

import pageObjects.LoginPage;
import pageObjects.MainPage;
import com.github.javafaker.Faker;
import helpers.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsTests.BaseTest;

public class PlayListTests2 extends BaseTest {


    @Test (invocationCount = 50)
    public void playlistTests_createPlaylist_playlistCreated() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_createPlaylist_playlistCreated0() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }


    @Test (invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        System.out.println(1);
        MainPage mainPage = loginPage.loginToApp(username, password);
        System.out.println(2);
        String playlistId = mainPage.createPlaylist(playlistName);
        System.out.println(3);
        String newPlaylistName = faker.artist().name();
        System.out.println(4);
        mainPage.renamePlaylist(playlistId, newPlaylistName);
        System.out.println(5);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }
    @Test (invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed0() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        System.out.println(1);
        MainPage mainPage = loginPage.loginToApp(username, password);
        System.out.println(2);
        String playlistId = mainPage.createPlaylist(playlistName);
        System.out.println(3);
        String newPlaylistName = faker.artist().name();
        System.out.println(4);
        mainPage.renamePlaylist(playlistId, newPlaylistName);
        System.out.println(5);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_createPlaylist_playlistCreated1() throws InterruptedException {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);
        int count = 0;
        for (int i = 0; i <1000 ; i++) {


            mainPage.createPlaylist(playlistName);

            count++;
        }
        System.out.println(count);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed1() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        String newPlaylistName = faker.artist().name();
        mainPage.renamePlaylist(playlistId, newPlaylistName);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }

    @Test
    public void playlistTests_createPlaylist_playlistCreated2() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }

    @Test(invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed2() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        String newPlaylistName = faker.artist().name();
        mainPage.renamePlaylist(playlistId, newPlaylistName);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }

    @Test
    public void playlistTests_createPlaylist_playlistCreated3() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed3() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        String newPlaylistName = faker.artist().name();
        mainPage.renamePlaylist(playlistId, newPlaylistName);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_createPlaylist_playlistCreated4() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }

    @Test (invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed4() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        String newPlaylistName = faker.artist().name();
        mainPage.renamePlaylist(playlistId, newPlaylistName);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }
    @Test (invocationCount = 50)
    public void playlistTests_createPlaylist_playlistCreated5() {
        Faker faker = new Faker();
        String playlistName = TestDataGenerator.getString(7);
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        Assert.assertTrue(mainPage.checkPlaylist(playlistId, playlistName));
    }
    @Test(invocationCount = 50)
    public void playlistTests_renamePlaylist_playlistRenamed5() {
        Faker faker = new Faker();
        String playlistName = faker.funnyName().name();
        System.out.println(playlistName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        String playlistId = mainPage.createPlaylist(playlistName);

        String newPlaylistName = faker.artist().name();
        mainPage.renamePlaylist(playlistId, newPlaylistName);


        Assert.assertTrue(mainPage.checkPlaylist(playlistId, newPlaylistName));
    }
    @Test
    public void playlistTests_deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        mainPage.deletePlaylists();
    }
}
