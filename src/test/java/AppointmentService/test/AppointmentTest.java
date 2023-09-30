package AppointmentService.test;

import AppointmentService.core.Appointment;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentTest {
	private Appointment appointment;
	private Date appointmentDate;
	long SECOND = 1000; // 1 second = 1000 milliseconds
	long MINUTE = 60;
	long HOUR = 60;
	long DAY = 24 * HOUR * MINUTE * SECOND;

    @Before
    public void setUp() {
    	// Get the current date
        Date currentDate = new Date();

        // Calculate the future date's time
        long futureDateInMillis = currentDate.getTime() + (DAY + HOUR * 2 + MINUTE * 30); // One day and two and a half hours later
        appointmentDate = new Date(futureDateInMillis);
        appointment = new Appointment("1", appointmentDate, "Meet with clients");
    }

    @Test
    public void testValidAppointmentCreation() {
        assertNotNull(appointment);
    }

    @Test
    public void testValidAppointmentDate() {
        assertEquals(appointmentDate, appointment.getAppointmentDate(appointment.getAppointmentId()));
    }

    @Test
    public void testValidAppointmentDescription() {
        assertEquals("Meet with clients", appointment.getAppointmentDescription(appointment.getAppointmentId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentId() {
        new Appointment(null, appointmentDate, "Meet with clients");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentDate() {
        new Appointment("1", null, "Meet with clients");
    }
}