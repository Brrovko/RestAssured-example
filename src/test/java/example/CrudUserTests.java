package example;

import example.dto.CreateUserRequest;
import example.dto.CreateUserResponse;
import example.dto.GetUserResponse;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class CrudUserTests extends TestBase{

    RequestSpecification requestSpecification = given().contentType(ContentType.JSON);
    ResponseSpecification responseSpecification = expect().statusCode(200);

    @Test
    public void createUserTest(){
        String job = "IT";

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Andrey");
        createUserRequest.setJob(job);

        CreateUserResponse response= given().spec(requestSpecification)
                .body(createUserRequest).when()
                .post(Endpoints.users)
                .as(CreateUserResponse.class);

        Assertions.assertEquals(job,response.getJob());
    }

    @Test
    public void getUserTest(){
        int userId = 2;
        GetUserResponse response = given().spec(requestSpecification).expect().spec(responseSpecification).when()
                .get(Endpoints.users + "/"+ userId).as(GetUserResponse.class);

        Assertions.assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
    }

    @Test
    public void getUserTest2(){
        int userId = 2;
        given().spec(requestSpecification).expect().spec(responseSpecification).when()
                .get(Endpoints.users + "/"+ userId);

    }
}
