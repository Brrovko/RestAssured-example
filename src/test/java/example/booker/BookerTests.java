package example.booker;

import example.booker.pojo.Booking;
import example.booker.pojo.BookingDates;
import example.booker.pojo.BookingInfo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookerTests extends TestBase{

    @Test
    public void bookerTest(){

        BookingDates bookingDates = new BookingDates("2021-08-31", "2021-09-10");
        Booking booking = new Booking("Martin", "Doe", 100, true, bookingDates, "Breakfast");

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

        assertThat(bookingInfo, hasProperty("bookingId"));
        assertThat(bookingInfo.getBooking(), hasProperty("firstname", equalTo("Martin")));
        assertThat(bookingInfo.getBooking().getTotalprice(),equalTo(100));

        Booking chekBooking = given()
                .get(Endpoints.booking + "/" + bookingInfo.getBookingId())
                .then()
                .extract().body().as(Booking.class);

        assertThat(chekBooking.getTotalprice(), equalTo(booking.getTotalprice()));

        assertThat(chekBooking, equalTo(booking));
        //Предпочтительнее, т.к. вывод более читабельный и понятный, указано конкретное свойство
        assertThat(chekBooking, samePropertyValuesAs(booking));
    }
}
