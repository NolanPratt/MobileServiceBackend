package AppointmentService.test;

import AppointmentService.core.Appointment;
import AppointmentService.core.AppointmentService;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentServiceTest {
	private AppointmentService service;

    @Before
    public void setUp() {
        service = new AppointmentService();
    }
    
    @After
    public void tearDown() {
    	service = null;
    }

    // Testing the appointment addition method
    @Test
    public void testAppointmentListInsertion() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
    	
        service.addAppointment(appointment);
        
        assertEquals(1, service.getAppointmentList().size()); // The appointment list should now be size 1
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
    	Appointment appointment1 = new Appointment("1", "01/12/2023", "Meet with clients");
        Appointment appointment2 = new Appointment("1", "01/12/2023", "Meet with clients");

        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidAppointmentDate() {
    	Appointment appointment = new Appointment("1", "01/12/2020", "Meet with clients");

        service.addAppointment(appointment);
    }
    
    // Testing the appointment deletion method
    @Test
    public void testDeleteAppointment() {
    	Appointment appointment1 = new Appointment("1", "01/12/2023", "Meet with clients");
        Appointment appointment2 = new Appointment("2", "01/12/2023", "Meet with CEO");

        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        service.deleteAppointment(appointment1.getAppointmentId());

        assertEquals(1, service.getAppointmentList().size()); // Only one appointment should be left
        assertEquals("2", service.getAppointmentList().get(0).getAppointmentId()); // The final appointment's Id should be 2
    }
    
    @Test
    public void testInvalidDeleteAppointment() {
    	Appointment appointment1 = new Appointment("1", "01/12/2023", "Meet with clients");
        Appointment appointment2 = new Appointment("2", "01/12/2023", "Meet with CEO");

        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        service.deleteAppointment("3");

        assertEquals(2, service.getAppointmentList().size()); // No appointments should be deleted
    }
    
    // Testing the appointment update method
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAppointmentId() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);

        // Update the appointment's id
        service.updateAppointment("1", "Appointment Id", "2");
    }
    
    @Test
    public void testUpdateValidAppointmentDate() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);

        // Update the appointment's name
        service.updateAppointment("1", "Appointment Date", "02/12/2023");

        Appointment updatedAppointment = service.getAppointmentList().get(0);
        assertEquals("02/12/2023", updatedAppointment.getFormattedAppointmentDate(updatedAppointment.getAppointmentId())); // The appointment's date should now be 02/12/2023 instead of 01/12/2023
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidAppointmentDate() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);

        // Update the appointment's name
        service.updateAppointment("1", "Appointment Date", "02/12/2020");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidFormattedAppointmentDate() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);

        // Update the appointment's name
        service.updateAppointment("1", "Appointment Date", "02122020");
    }
    
    @Test
    public void testUpdateValidAppointmentDescription() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);

        // Update the appointment's description
        service.updateAppointment("1", "Appointment Description", "Meet with Artemis Financial");

        Appointment updatedAppointment = service.getAppointmentList().get(0);
        assertEquals("Meet with Artemis Financial", updatedAppointment.getAppointmentDescription(updatedAppointment.getAppointmentId())); // The appointment's description should now be changed
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidAppointmentDescription() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);
        service.updateAppointment("1", "Appointment Description", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidAppointmentDescriptionLength() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);
        service.updateAppointment("1", "Appointment Description", "Arrive to work, meet with receptionist, wait in front office, meet with client, address business concerns, resolve issues, conclude meeting, return to base.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistingAppointment() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);
        service.updateAppointment("2", "Appointment Date", "02/12/2023");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidAppointmentField() {
    	Appointment appointment = new Appointment("1", "01/12/2023", "Meet with clients");
        service.addAppointment(appointment);
        service.updateAppointment("1", "Appointment Time", "2:00");
    }
}
