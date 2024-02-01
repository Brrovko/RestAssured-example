package example.booker.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
public class BookingDates {

    @JsonProperty("checkin")
    private String startTime;

    @JsonProperty("checkout")
    private String finishTime;

    @JsonIgnore
    private String extraField;

    public BookingDates(String checkin, String checkout) {
        this.startTime = checkin;
        this.finishTime = checkout;
    }

    public BookingDates() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDates that = (BookingDates) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, finishTime);
    }
}
