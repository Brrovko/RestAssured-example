package example.booker;

import example.booker.pojo.Booking;
import example.booker.pojo.BookingDates;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookerTests extends TestBase{

    @Test
    public void bookerTest(){

        BookingDates bookingDates = new BookingDates("2021-08-31", "2021-09-10");
        Booking booking = new Booking("John", "Doe", 100, true, bookingDates, "Breakfast");

        given()
                .contentType("application/json")
                .accept("application/json")
                .body(booking)
                .post(Endpoints.booking)
                .then()
                .statusCode(200);
    }
}
