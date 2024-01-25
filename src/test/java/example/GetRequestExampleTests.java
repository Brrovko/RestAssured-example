package example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRequestExampleTests {

    @Test
    public void statusCodeTest(){

        //https://reqres.in/api/users

        given().baseUri("https://reqres.in").log().all()
                .when()
                .get("/api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void addParamTest(){

        given().baseUri("https://reqres.in").log().all()
                .when()
                .param("page", 2)
                .get("/api/" + Endpoints.users)
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void checkHeaderTest(){

        given().baseUri("https://reqres.in").contentType(ContentType.JSON).log().all()
                .when()
                .get("/api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Test
    public void checkResponseTest(){

        Response response = RestAssured.given().baseUri("https://reqres.in").contentType(ContentType.JSON).log().all()
                .when()
                .get("/api/users");

        System.out.println(response.prettyPrint());

        Assertions.assertTrue(response.body().asString().contains("charles.morris@reqres.in"));
    }
}
