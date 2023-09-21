package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage  extends BasePage{


    public MainPage(WebDriver driver) {
        super(driver);

    }

    private WebElement getPlusButton() {
        By plusButtonBy = By.xpath("//*[@title='Create a new playlist']");
        wait.until(ExpectedConditions.elementToBeClickable(plusButtonBy));
        return driver.findElement(plusButtonBy);
    }

    private WebElement getNewPlayListItem() {
        return driver.findElement(By.xpath("//*[text()='New Playlist']"));

    }

    private WebElement getEditPlaylistField() {
        return driver.findElement(By.xpath("//*[@class='create']/input"));
    }


    public boolean isMain() {
        By homeBy = By.className("home");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeBy));
            return true;
        } catch (TimeoutException xx) {
            return false;
        }
    }

    public String createPlaylist(String playlistName) {

        String playlistId = "";
        getPlusButton().click();
        getNewPlayListItem().click();
        getEditPlaylistField().sendKeys(playlistName);
        getEditPlaylistField().sendKeys(Keys.ENTER);
        By successBy = By.xpath("//*[@class='success show']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successBy));
        System.out.println(driver.getCurrentUrl());
        /**
         * Получение ID
         *
         */


        String url = driver.getCurrentUrl();
        playlistId = url.split("/")[5];
        System.out.println(playlistId);
        System.out.println(playlistName);
        return playlistId;
    }


    public boolean checkPlaylist(String playlistId, String playlistName) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            By playlistBy = getPlaylistBy(playlistId);
//            WebElement playlist= driver.findElement(playlistBy);
//            js.executeScript("arguments[0].scrollIntoView();", playlist);
//
//            try {
//
//                wait.until(ExpectedConditions.visibilityOfElementLocated(playlistBy));
//                String name = driver.findElement(playlistBy).getText();
//                return  name.equals(playlistName);
//            } catch (TimeoutException c){
//                return false;
//            }
        By playlistBy = By.xpath("//*[@href='#!/playlist/" + playlistId + "']");
        try {
//
            wait.until(ExpectedConditions.visibilityOfElementLocated(playlistBy));
            String name = driver.findElement(playlistBy).getText();
            return name.equals(playlistName);
        } catch (TimeoutException c) {
            return false;
        }
    }

    public void renamePlaylist(String playlistId, String newPlaylistName) {
    }
}

