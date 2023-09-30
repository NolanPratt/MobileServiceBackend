package AppointmentService.test;

import AppointmentService.core.Appointment;
import AppointmentService.core.AppointmentService;
import java.util.Date;
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

    @Test
    public void testTaskListCreation() {
    	assertEquals(0, service.getAppointmentList().size()); // The appointment list should now be size 0
    }
    
    @Test
    public void testTaskListAddition() {
    	Appointment appointment = new Appointment("1", "01/01/1990", "Meet with clients");
    	
        service.addAppointment(appointment);
        
        assertEquals(1, service.getAppointmentList().size()); // The appointment list should now be size 1
    }

    @Test
    public void testAddDuplicateTask() {
        Appointment appointment1 = new Appointment("1", "01/01/1990", "Meet with clients");
        Appointment appointment2 = new Appointment("1", "01/01/1990", "Lunch with investors");

        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        assertEquals(1, service.getAppointmentList().size()); // Only one appointment should be added
    }
    
    @Test
    public void testDeleteTask() {
    	Appointment appointment1 = new Appointment("1", "01/01/1990", "Meet with clients");
        Appointment appointment2 = new Appointment("2", "01/01/1990", "Lunch with investors");

        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        service.deleteAppointment(appointment1.getAppointmentId());

        assertEquals(1, service.getAppointmentList().size()); // Only one appointment should be left
        assertEquals("2", service.getAppointmentList().get(0).getAppointmentId()); // The final appointment's Id should be 2
    }
    
    @Test
    public void testUpdateTask() {
    	Appointment appointment = new Appointment("1", "01/01/1990", "Meet with clients");
        service.addAppointment(appointment);

        // Update the task's name
        service.updateAppointment("1", "Appointment Date", "01/02/1990");

        Appointment updatedAppointment = service.getAppointmentList().get(0);
        assertEquals("01/02/1990", updatedAppointment.getAppointmentDate(updatedAppointment.getAppointmentId())); // The appointment's date should now be 01/02/1990 instead of 01/01/1990
    }
}
