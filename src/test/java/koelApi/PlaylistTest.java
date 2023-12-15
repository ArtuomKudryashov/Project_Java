package koelApi;

import com.github.javafaker.Faker;
import helpers.TestDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.CreatePlaylistRequest;
import models.CreatePlaylistResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlaylistTest {
    private int playlistId;
    private String token;
    private String plName;

    @BeforeMethod
    public void createNewPlaylist() {
        token = TestDataGenerator.getToken();
        Faker faker = new Faker();
        plName = faker.artist().name();
        System.out.println(plName);

        CreatePlaylistRequest pl = new CreatePlaylistRequest(plName);
        Response response = given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(pl)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        playlistId = jsonPath.getInt("id");

        System.out.println(playlistId);


    }

    @AfterMethod
    public void tearDown() {
        given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist/" + playlistId)
                .header("Authorization", token)
                .when()
                .delete();


    }

    @Test
    public void test() {
        System.out.println(3);
        Response response = given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist")
                .header("Content-Type", "application/json")
                .header("Authorization", token)

                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(1);
        CreatePlaylistResponse[] playlists = jsonPath.getObject("$", CreatePlaylistResponse[].class);
        System.out.println(2);
        int count = 0;
        for (CreatePlaylistResponse pl : playlists) {
            if (pl.getId() == playlistId && pl.getName().equals(plName)) {
                System.out.println("Name");
                System.out.println(pl.getName());
                count++;
            }


        }

    }
    @Test
    public void testRenamePlaylist() {
        // Создаем новый плейлист
        CreatePlaylistRequest createPlaylistRequest = new CreatePlaylistRequest("Initial Playlist Name");
        Response createResponse = given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(createPlaylistRequest)
                .when()
                .post();

        JsonPath createJsonPath = createResponse.jsonPath();
        int playlistId = createJsonPath.getInt("id");

        // Проверяем успешное создание плейлиста
        createResponse.then().statusCode(200);

        // Переименовываем плейлист
        Faker faker = new Faker();
        String plnewName = faker.artist().name();
        Response renameResponse = given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist/" + playlistId)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + plnewName + "\"" +
                        "}")
                .when()
                .put();

        // Проверяем успешное переименование плейлиста
        renameResponse.then().statusCode(200);

        // Получаем обновленные данные о плейлисте
        Response getResponse = given()
                .baseUri("https://qa.koel.app/")
                .basePath("api/playlist")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get();

        JsonPath getJsonPath = getResponse.jsonPath();
        CreatePlaylistResponse[] playlists = getJsonPath.getObject("$", CreatePlaylistResponse[].class);

        // Проверяем, что плейлист был успешно переименован
        boolean isPlaylistRenamed = false;
        for (CreatePlaylistResponse pl : playlists) {
            if (pl.getId() == playlistId && pl.getName().equals(plnewName)) {
                isPlaylistRenamed = true;
                break;
            }
        }

        // Выводим результат проверки
        if (isPlaylistRenamed) {
            System.out.println("Playlist successfully renamed to: " + plnewName);
        } else {
            System.out.println("Playlist renaming failed.");
        }
    }
}











