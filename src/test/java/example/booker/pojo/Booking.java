package example.booker.pojo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Booking {
    private String firstname;

    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
    public Booking() {
    }

    public Booking(String firstname, String lastnameUser, Integer totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastnameUser;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(firstname, booking.firstname) && Objects.equals(lastname, booking.lastname) && Objects.equals(totalprice, booking.totalprice) && Objects.equals(depositpaid, booking.depositpaid) && Objects.equals(bookingdates, booking.bookingdates) && Objects.equals(additionalneeds, booking.additionalneeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
    }
}
