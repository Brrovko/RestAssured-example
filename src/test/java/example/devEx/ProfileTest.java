package example.devEx;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ProfileTest extends TestBase{

    @Test
    public void getProfileTest(){
        int userId = 531;
        Response response = given().queryParam("id", userId).when().get(Endpoints.profileUserQuery);

        Assertions.assertEquals(response.statusCode(), 200);

        System.out.println(response.path("id").toString());

        int id = response.path("id");
        int profileId = response.path("profileId");

        Assertions.assertEquals(id, userId);
        Assertions.assertEquals(response.path("email"), "berlin@gmail.com");
        Assertions.assertEquals(response.path("name"), "Babamyrat");
        Assertions.assertEquals(response.path("company"), "Kshlerin - Reilly");
        Assertions.assertEquals(response.path("status"), "uz");
        Assertions.assertEquals(profileId, 291);

    }
}
