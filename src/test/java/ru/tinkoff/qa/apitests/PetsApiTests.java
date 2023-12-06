package ru.tinkoff.qa.apitests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.qa.apimodels.PetRequest;
import ru.tinkoff.qa.builder.PetBuilder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetsApiTests {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/pet/";
    PetRequest petRequest;
    @BeforeEach
    public void init(){
        petRequest = new PetRequest();
        PetBuilder builder = new PetBuilder(1461681516);
        builder.setName("dog");
        builder.setStatus("available");
        petRequest = builder.build();
    }

    @Test
    public void addPet(){
        PetRequest petResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .body(petRequest)
                .post(BASE_URI)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(PetRequest.class);
        petRequest.setId(petResponse.getId());
        assertEquals(petRequest.name, petResponse.name, "Check add pet");
    }

    @Test
    public void getPet(){
        PetRequest petResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URI + petRequest.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(PetRequest.class);
        assertEquals("dog", petResponse.getName(), "Check get name");
    }

    @Test
    public void petPut(){
        petRequest.setName("cat");
        PetRequest petResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .body(petRequest)
                .baseUri(BASE_URI)
                .put()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(PetRequest.class);
        assertEquals("cat", petResponse.getName(), "Check change name");
    }

    @Test
    public void deletePet(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(BASE_URI + petRequest.id)
                .then()
                .statusCode(200);
    }
}
