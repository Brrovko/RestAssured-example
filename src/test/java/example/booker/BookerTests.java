package example.booker;

import example.booker.pojo.Booking;
import example.booker.pojo.BookingDates;
import example.booker.pojo.BookingInfo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookerTests extends TestBase{

    @Test
    public void bookerTest(){

        BookingDates bookingDates = new BookingDates("2021-08-31", "2021-09-10");
        Booking booking = new Booking("John", "Doe", 100, true, bookingDates, "Breakfast");

        //Серилизация
        given()
                .contentType("application/json")
                .accept("application/json")
                .body(booking)
                .post(Endpoints.booking)
                .then()
                .statusCode(200);

        //Десерилизация
        BookingInfo bookingInfo = given()
                .contentType("application/json")
                .accept("application/json")
                .body(booking)
                .when()
                .post(Endpoints.booking)
                .then()
                .extract().body().as(BookingInfo.class);
    }
}
