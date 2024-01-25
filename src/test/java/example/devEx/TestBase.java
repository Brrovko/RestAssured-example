package example.devEx;

import example.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class TestBase {

    @BeforeAll
    public static void restAssuredSetup(){

        RestAssured.baseURI =  ConfigurationReader.get("devEx_url");;
        RestAssured.basePath = "api";
        RestAssured.requestSpecification = given().accept(ContentType.ANY);
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
