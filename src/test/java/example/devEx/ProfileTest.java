package example.devEx;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ProfileTest extends TestBase{

    @Test
    public void getProfileUserQueryTest(){

        int userId = 531;
        Response response = given()
                .queryParam("id", userId)
                .when()
                .get(Endpoints.profileUserQuery);

        Assertions.assertEquals(response.statusCode(), 200);

        int id = response.path("id");
        int profileId = response.path("profileId");

        Assertions.assertEquals(userId, id);
        Assertions.assertEquals("berlin@gmail.com", response.path("email"));
        Assertions.assertEquals("Babamyrat", response.path("name"));
        Assertions.assertEquals("Kshlerin - Reilly", response.path("company"));
        Assertions.assertEquals("uz", response.path("status"));
        Assertions.assertEquals(291, profileId);
    }

    @Test
    public void checkHeaderTest(){
        Response response = when().get(Endpoints.profile);

        Assertions.assertEquals("application/json; charset=utf-8", response.header("Content-type"));
        Assertions.assertTrue(response.headers().hasHeaderWithName("date"));
    }

    @Test
    public void getProfileTest(){
        Response response = when().get(Endpoints.profile);

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getInt("id[1]"));

        List<Object> allCompanies = jsonPath.getList("company");
        System.out.println(allCompanies);
    }

    @Test
    public void profileHasItemTest(){
        when().get(Endpoints.profile).then().body("user.name", hasItems("sylvester", "CraigDavid", "Necip", "Mike Masters"));
    }

    @Test
    public void profileEqualToTest(){
        when().get(Endpoints.profile).then().body("company[1]", equalTo("Eurotech"), "skills[1][4]", equalTo("API"));
    }
}