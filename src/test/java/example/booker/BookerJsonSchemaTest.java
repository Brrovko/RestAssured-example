package example.booker;

import example.booker.pojo.Booking;
import example.booker.pojo.BookingDates;
import example.booker.pojo.BookingInfo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BookerJsonSchemaTest extends TestBase{

    @Test
    public void bookerSchemaValidation(){
        BookingDates bookingDates = new BookingDates("2021-08-31", "2021-09-10");
        Booking booking = new Booking("Martin", "Doe", 100, true, bookingDates, "Breakfast");

        BookingInfo bookingInfo = given()
                .contentType("application/json")
                .accept("application/json")
                .body(booking)
                .when()
                .post(Endpoints.booking)
                .then()
                .extract().body().as(BookingInfo.class);

                given()
                .get(Endpoints.booking + "/" + bookingInfo.getBookingId())
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"));

    }
}
