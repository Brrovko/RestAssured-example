package example.booker;

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
        RestAssured.baseURI = ConfigurationReader.get("booker_url");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
