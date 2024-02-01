package example.booker.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BookingInfo {
    @JsonAlias({"bookingid", "bookingID", "bookingId"})
    private int bookingId;
    private Booking booking;

    public BookingInfo() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

}
