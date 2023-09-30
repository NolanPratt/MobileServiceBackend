package AppointmentService.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class AppointmentService {
	private List<Appointment> appointmentList = new ArrayList<>();
	long SECOND = 1000; // 1 second = 1000 milliseconds
	long MINUTE = 60;
	long HOUR = 60;
	long DAY = 24 * HOUR * MINUTE * SECOND;
	
	// Constructor
	public AppointmentService() {
		
	}
	
	public List<Appointment> getAppointmentList() {
		return this.appointmentList;
	}
	
	// Add a new Appointment to the Task list
	public void addAppointment(Appointment appointment) {
		// Duplicate Appointment check
		if (appointmentExists(appointment)) {
	        throw new IllegalArgumentException("Error: Duplicate Appointment. Appointment with ID " + appointment.getAppointmentId() + " already exists.");
	    } 
		// Invalid Appointment Date check
		else if (dateIsValid(appointment.getAppointmentDate(appointment.getAppointmentId()))) {
			throw new IllegalArgumentException("Error: Invalid Appointment Date. Appointment Date of " + appointment.getAppointmentDate(appointment.getAppointmentId()) + " is invalid.");
		}	
		else {
	        appointmentList.add(appointment);
	    }
	}
	
	// Check whether a Appointment already exists within the Appointment list
	public boolean appointmentExists(Appointment appointment) {
		for (Appointment appointments : appointmentList) {
			if (appointments.getAppointmentId().equals(appointment.getAppointmentId())) {
				return true;
			}
		}
		return false;
	}
	
	// Iterate through the Appointment list and delete the Appointment object with a matching Id
	public void deleteAppointment(String appointmentId) {
		for (Appointment appointment : appointmentList) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				appointmentList.remove(appointment);
			}
		}
	}
	
	// Update a Appointment's specified field to a new value
	public void updateAppointment(String appointmentId, String fieldToUpdate, String newValue) {
		for (Appointment appointment : appointmentList) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				switch (fieldToUpdate) {
				// Handle invalid Id updates
			    case "Appointment Id":
			        throw new IllegalArgumentException("Invalid Request: Appointment Id is Immutable.");
			    // Handle Date updates
			    case "Appointment Date":
			    	updateAppointment(appointmentId, new Date(
			    			Integer.valueOf(newValue.substring(0,1)) * DAY +		// Day
			    			Integer.valueOf(newValue.substring(3,4)) * DAY * 30 + 	// Month
			    			Integer.valueOf(newValue.substring(6,9)) * DAY * 365));	// Year
			    // Handle description updates
			    case "Appointment Description":
			    	appointment.setAppointmentDescription(newValue);
			    	System.out.println("Update Success: Appointment Description Changed.");
			        break;
			    // All other cases
			    default:
			    	throw new IllegalArgumentException("Invalid Field");
				}
				break;
			}
		}
	}
	
	// Update a Appointment's specified field to a new value
	public void updateAppointment(String appointmentId, Date newValue) {
		for (Appointment appointment : appointmentList) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
		    	appointment.setAppointmentDate(newValue);
		    	System.out.println("Update Success: Appointment Date Changed.");
			}
		}
	}
		
	
	// Check whether a Date is eligible for scheduling an appointment
    public boolean dateIsValid(Date date) {
        if (date.before(new Date())) {
            return false;
        }
        return true;
    }
}
