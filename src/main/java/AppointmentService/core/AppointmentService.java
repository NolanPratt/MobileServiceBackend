package AppointmentService.core;

import java.util.ArrayList;
import java.util.List;


public class AppointmentService {
	private List<Appointment> appointmentList = new ArrayList<>();
	
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
			    	appointment.setAppointmentDate(newValue);
			    	System.out.println("Update Success: Appointment Date Changed.");
			    	return;
			    // Handle description updates
			    case "Appointment Description":
			    	appointment.setAppointmentDescription(newValue);
			    	System.out.println("Update Success: Appointment Description Changed.");
			    	return;
			    // All other cases
			    default:
			    	throw new IllegalArgumentException("Invalid Field");
				}
			}
		}
		throw new IllegalArgumentException("Error: Appointment with Id " + appointmentId + " Not Found");
	}	
}
