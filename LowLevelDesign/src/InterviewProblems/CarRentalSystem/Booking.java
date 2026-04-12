package InterviewProblems.CarRentalSystem;

import java.time.LocalDate;

public class Booking {

    private final String bookingId;
    private final User user;

    private final  Car car;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final double amount;

    public Booking(String bookingId, User user,Car car,LocalDate startDate, LocalDate endDate, double amount){
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }
}
