package AppointmentService.core;

import java.util.Date;

public class Appointment {
	private String appointmentId = "";
	private Date appointmentDate; // FIXME: Update Date set interface to accept String, add Date calculation logic into Appointment class to minimize external repetition
	private String appointmentDescription = "";
	
	// Constructors 
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointmentId. It must be a non-null string of up to 10 characters.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointmentDate. It must be a non-null date after today's date.");
        }
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid appointmentDescription. It must be a non-null string of up to 50 characters.");
        }
        
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
	// Setters
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
    		throw new IllegalArgumentException("Invalid appointmentDate. It must be a non-null date after today's date.");
    	} else {
    		this.appointmentDate = appointmentDate;
    	}
	}
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointmentDescription. It must be a non-null string of up to 50 characters.");
    	} else {
    		this.appointmentDescription = appointmentDescription;
    	}
	}
	
	//Getters
	public String getAppointmentId() {
		return this.appointmentId;
	}
	public Date getAppointmentDate(String appointmentId) {
		return this.appointmentDate;
	}
	public String getAppointmentDescription(String appointmentId) {
		return this.appointmentDescription;
	}
}
