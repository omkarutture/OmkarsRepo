package filmBookingRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\ticketBooking\\FilmTicket.feature"},
		
		glue = {"filmBookingSteps"},
		
		plugin = {"pretty"}
		)

public class BookingRunner extends AbstractTestNGCucumberTests {

}
