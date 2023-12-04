package apiPetStore;

import helpers.TestDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.Socket;

import static io.restassured.RestAssured.given;

public class PetStore {
//    private Pet pet;
//    private long petId;
//    @BeforeMethod
//    public  void startUp(){
//        pet= TestDataGenerator.generateRandomPet();
//        Response response =given()
//                .baseUri("https://petstore.swagger.io/v2")
//                .basePath("/pet")
//                .header("Content-Type", "application/json")
//                .body(pet)
//
//                .when()
//                .post()
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//        JsonPath jsonPath = response.jsonPath();
//        petId = jsonPath.getLong("id");
//        System.out.println(petId);
//
//    }
    @Test
    public void getPetById_petReturned(){
        Response response =given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/100")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        response.print();
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Pet responsePet = jsonPath.getObject("$",Pet.class);
//        Assert.assertEquals(responsePet.getName(),pet.getName());
        Category responseCategory = jsonPath.getObject("category",Category.class);


//
        System.out.println(responsePet.getName());

    }
}
