package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class MainPage  extends BasePage{
    private static Logger logger = LogManager.getLogger(MainPage.class);


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

    private WebElement getCreatePlaylistField() {
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
        logger.debug("Create playLiist with name -> "+playlistName);
        logger.info("Create Playlist with name -> " +playlistName);

        String playlistId = "";
        getPlusButton().click();
        logger.trace("plus button clicked");
        getNewPlayListItem().click();
        getCreatePlaylistField().sendKeys(playlistName);
        getCreatePlaylistField().sendKeys(Keys.ENTER);
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
    private By getPlaylistBy(String playlistId) {
        return By.xpath("//*[@href='#!/playlist/" + playlistId + "']");
    }


    public boolean checkPlaylist(String playlistId, String playlistName) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            By playlistBy = getPlaylistBy(playlistId);
            WebElement playlist= driver.findElement(playlistBy);
            js.executeScript("arguments[0].scrollIntoView();", playlist);
//
            try {
//
                wait.until(ExpectedConditions.visibilityOfElementLocated(playlistBy));
                String name = driver.findElement(playlistBy).getText();
                return  name.equals(playlistName);
            } catch (TimeoutException c){
                return false;
            }
//        By playlistBy = By.xpath("//*[@href='#!/playlist/" + playlistId + "']");
//        try {
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(playlistBy));
//            String name = driver.findElement(playlistBy).getText();
//            return name.equals(playlistName);
//        } catch (TimeoutException c) {
//            return false;
//        }
    }

    public void renamePlaylist(String playlistId, String newPlaylistName) {
        logger.debug("Updating playlist id " +playlistId);
        logger.debug("New playlist name = " + newPlaylistName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By playlistBy = getPlaylistBy(playlistId);
        WebElement playlist= driver.findElement(playlistBy);
        js.executeScript("arguments[0].scrollIntoView();", playlist);


        Actions actions =new Actions(driver);
        actions.doubleClick(playlist).perform();
//
        WebElement editingField= getEditPlaylistField(playlistId);
        editingField.sendKeys(Keys.CONTROL+"A");
        editingField.sendKeys(newPlaylistName);
        editingField.sendKeys(Keys.ENTER);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private WebElement getEditPlaylistField(String playlistId) {
        By editBy= By.xpath("//*[@type='text']");
        wait.until(ExpectedConditions.elementToBeClickable(editBy));
        return driver.findElement(editBy);

    }
    public List<WebElement> getPlaylists() {
        System.out.println(-2);
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200)); // Ждем до 10 секунд
        By playlistsLocator = By.xpath("//li[@class='playlist playlist']");

        // Ждем, пока появятся элементы
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(playlistsLocator));

        List<WebElement> playlists = driver.findElements(playlistsLocator);
        System.out.println("Size of playlists: " + playlists.size());
        return playlists;
    }

    public void deletePlaylists() throws InterruptedException {
        System.out.println(1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(2);
        List<String> playlists = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul/li[@class='playlist playlist']")))
                .stream().map(WebElement::getText).toList();
        System.out.println(3);
        System.out.println("Size: " + playlists.size());
        System.out.println(4);

        for (int i = 0; i < 10; i++) {
            System.out.println("Playlist " + (i + 1) + ": " + playlists.get(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(5);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = '%s']/..".formatted(playlists.get(i)))));
            System.out.println(6);
            Actions actions = new Actions(driver);
            System.out.println(7);
            actions.contextClick(element).perform();
            System.out.println(8);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]")))
                    .click();
            System.out.println(9);

        }


    }


    //
//
    public void deletePlaylists2() throws InterruptedException {
        System.out.println(1);
        List<WebElement> playlists = getPlaylists();
        System.out.println(2);
        System.out.println("Size: " + playlists.size());

        // Используем цикл foreach
        for (WebElement playlist : playlists.subList(2, (playlists.size() - 1))) {
            Actions actions = new Actions(driver);
            actions.contextClick(playlist).perform();
            By delBy = By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]");
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(delBy));
            deleteButton.click();
        }

        List<WebElement> remainingPlaylists = getPlaylists();
        System.out.println("Remaining playlists: " + remainingPlaylists.size());
    }
    public void deletePlaylists3() throws InterruptedException {
        List<WebElement> playlists = getPlaylists();
        System.out.println("Size of playlists: " + playlists.size());

        for (int i = playlists.size()-1; i >=0; i--) {
            WebElement playlist = playlists.get(i);

            Actions actions = new Actions(driver);
            actions.contextClick(playlist).perform();

            By delBy = By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            try {
                WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(delBy));
                delete.click();
            } catch (Exception e) {
                System.err.println("Ошибка при удалении плейлиста: " + e.getMessage());
            }
        }
    }

    public void deletePlaylists4() throws InterruptedException {
        List<WebElement> playlists = getPlaylists();
        System.out.println("Size of playlists: " + playlists.size());

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = playlists.size() - 1; i >= 0; i--) {
            WebElement playlist = playlists.get(i);

            // Выполняем контекстный клик
            actions.contextClick(playlist).build().perform();

            By delBy = By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]");

            // Дожидаемся появления элемента для удаления
            WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(delBy));

            // Выполняем клик на элементе удаления
            actions.click(delete).build().perform();

            // Дожидаемся исчезновения элемента после удаления
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(delBy));
            } catch (TimeoutException e) {
                System.err.println("Таймаут ожидания исчезновения элемента после удаления. Плейлист может быть не удален.");
                // Продолжаем выполнение, возможно, плейлист уже удален или произошла другая ошибка
            }

            // Добавьте небольшую паузу (можно использовать TimeUnit.SECONDS.sleep(1) для паузы в 1 секунду)
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            playlists=getPlaylists();
        }
    }
    public void deletePlaylists5() {
        List<WebElement> playlists = getPlaylists();
        ListIterator<WebElement> iterator = playlists.listIterator(playlists.size());

        while (iterator.hasPrevious()) {
            WebElement playlist = iterator.previous();

            // Создаем объект Actions
            Actions actions = new Actions(driver);

            // Выполняем контекстный клик
            actions.contextClick(playlist).build().perform();

            By delBy = By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]");

            // Используем явные ожидания для появления элемента перед взаимодействием
            WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
            WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(delBy));

            // Выполняем клик на элементе удаления
            actions.click(delete).build().perform();

            // Дожидаемся исчезновения элемента после удаления
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(delBy));
            } catch (TimeoutException e) {
                System.err.println("Таймаут ожидания исчезновения элемента после удаления. Плейлист может быть не удален.");
                // Продолжаем выполнение, возможно, плейлист уже удален или произошла другая ошибка
            }

            // Обработка исключения StaleElementReferenceException
            try {
                // Добавьте небольшую паузу (можно использовать TimeUnit.SECONDS.sleep(1) для паузы в 1 секунду)
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Обновляем список после удаления
            playlists = getPlaylists();
            iterator = playlists.listIterator(playlists.size());
        }
    }
}

