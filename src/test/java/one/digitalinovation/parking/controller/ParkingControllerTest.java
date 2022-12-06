package one.digitalinovation.parking.controller;

import io.restassured.RestAssured;
import one.digitalinovation.parking.dto.ParkingDTO;
import one.digitalinovation.parking.model.Parking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUptest(){
        System.out.println("Porta Randomica: "+randomPort);
        RestAssured.port = randomPort;
    }


    @Test
    void whenSaveThenCheckResult() {



    }

    @Test
    void whenFindAllThenCheckResult() {

        RestAssured.given()
                .when()
                .get("/parking/all")
                .then()
                .statusCode(200)
                .extract().response().body().prettyPrint();
    }

    @Test
    void checkout() {

        
    }
}