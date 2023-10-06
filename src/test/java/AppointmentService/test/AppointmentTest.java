package AppointmentService.test;

import AppointmentService.core.Appointment;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentTest {
	private Appointment appointment;

    @Before
    public void setUp() {
        appointment = new Appointment("1", "01/12/2023", "Meet with clients");
    }
    
    @After
    public void tearDown() {
    	appointment = null;
    }

    // Testing valid Appointment definitions
    @Test
    public void testValidAppointmentCreation() {
        assertNotNull(appointment);
    }

    @Test
    public void testValidAppointmentId() {
        assertEquals("1", appointment.getAppointmentId());
    }
    
    @Test
    public void testValidAppointmentDate() {
        assertEquals("01/12/2023", appointment.getFormattedAppointmentDate(appointment.getAppointmentId()));
    }

    @Test
    public void testValidAppointmentDescription() {
        assertEquals("Meet with clients", appointment.getAppointmentDescription(appointment.getAppointmentId()));
    }

    // Testing null attributes
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentCreation() {
        new Appointment(null, null, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentId() {
        new Appointment(null, "01/12/2023", "Meet with clients");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentDate() {
        new Appointment("1", null, "Meet with clients");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAppointmentDate() {
    	appointment.setAppointmentDate(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentDescription() {
        new Appointment("1", "01/12/2023", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAppointmentDescription() {
        appointment.setAppointmentDescription(null);
    }
    
    // Testing satisfaction of attribute requirements
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentIdLength() {
    	new Appointment("123456789123456789", "01/12/2023", "Meet with clients");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPastAppointmentDate() {
    	new Appointment("1", "01/01/2020", "Meet with clients");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidPastAppointmentDate() {
    	appointment.setAppointmentDate("01/01/2020");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidAppointmentDateFormattingDDMMYY() {
    	new Appointment("1", "010115", "Meet with clients");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFormatAppointmentDateDDMMYY() {
    	appointment.setAppointmentDate("010115");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidAppointmentDateFormattingDDMMYYYY() {
    	new Appointment("1", "01012015", "Meet with clients");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFormatAppointmentDateDDMMYYYY() {
    	appointment.setAppointmentDate("01012015");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentDescriptionLength() {
    	new Appointment("1","01/12/2023", "Arrive to work, meet with receptionist, wait in front office, meet with client, address business concerns, resolve issues, conclude meeting, return to base.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAppointmentDescriptionLength() {
        appointment.setAppointmentDescription("Arrive to work, meet with receptionist, wait in front office, meet with client, address business concerns, resolve issues, conclude meeting, return to base.");
    }
}