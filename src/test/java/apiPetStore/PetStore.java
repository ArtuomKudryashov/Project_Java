package apiPetStore;

import helpers.TestDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.Socket;

import static io.restassured.RestAssured.given;

public class PetStore {
    private Pet pet;
    private long petId;
    private String petName;

    @BeforeMethod
    public void startUp() {
        pet = TestDataGenerator.generateRandomPet();
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("Content-Type", "application/json")
                .body(pet)

                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        petId= jsonPath.getLong("id");
        petName = jsonPath.getString("name");
        System.out.println(petId);
        System.out.println(petName);


    }

//    @AfterMethod
//    public void tearDown() {
//        System.out.println(7);
//        Response response = given()
//                .baseUri("https://petstore.swagger.io/v2")
//                .basePath("/pet/" + petId)
//                .when()
//                .delete()
//                .then()
//                .statusCode(200) // Убедитесь, что код состояния после удаления - 200
//                .extract()
//                .response();
//        System.out.println(8);
//    }

    @Test
    public void getPetById_petReturned() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/"+petId)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        response.print();
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Pet responsePet = jsonPath.getObject("$", Pet.class);

        System.out.println("Print ");

        System.out.println(responsePet.getName());
//
        Category responseCategory = jsonPath.getObject("category", Category.class);
//
        System.out.println("1");
        System.out.println(responseCategory.getName());
        System.out.println(responsePet.getName());
        System.out.println("2");
        System.out.println(responsePet.getCategory().getName());
        System.out.println(3);
//
        Assert.assertEquals(responsePet.getName(), pet.getName());
        System.out.println(4);
        Assert.assertEquals(responsePet.getCategory().getId(), pet.getCategory().getId());
        System.out.println(5);
        Assert.assertEquals(responsePet.getCategory().getName(), pet.getCategory().getName());
        System.out.println(6);
//
//
    }
    @Test
    public void updateExistingPet(){
        Pet updatedPet = TestDataGenerator.generateRandomPet();
        updatedPet.setId(petId);
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("Content-Type", "application/json")
                .body(updatedPet)

                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        Pet responsePet = jsonPath.getObject("$", Pet.class);

        Assert.assertEquals(responsePet.getName(), updatedPet.getName());
        System.out.println("4-2");
        Assert.assertEquals(responsePet.getCategory().getId(), updatedPet.getCategory().getId());
        System.out.println("5-2");
        Assert.assertEquals(responsePet.getCategory().getName(), updatedPet.getCategory().getName());
        System.out.println("6-2");

    }
}
