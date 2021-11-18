import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.mashape.unirest.http.*;
import java.io.*;
import java.io.File;
import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class APITestFactorial {

    String uRLApi = "http://qainterview.pythonanywhere.com/factorial";



    @Test
    @DisplayName("When get check if the server is up then return Http Status 220 to check if the server is on")
    public void getHttpStatus200 (){

        given()
                .contentType("multipart/form-data")
                .multiPart("number",6)
        .when()
                .post(uRLApi)
        .then()
                .statusCode(200);

    };

    @Test
    @DisplayName("When post factorial number 6 then return 720")
    public void getFactorial6 (){

        given()
                .contentType("multipart/form-data")
                .multiPart("number","df")
        .when()
                .post(uRLApi)
        .then()
                .body("answer",equalTo(720));

    };

    @Test
    @DisplayName("When post factorial from a string then return error 500")
    public void getFactorialString (){

        given()
                .contentType("multipart/form-data")
                .multiPart("number","XX")
                .when()
                .post(uRLApi)
                .then()
                .statusCode(500);

    };




}
