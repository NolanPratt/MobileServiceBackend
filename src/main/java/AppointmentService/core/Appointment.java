package AppointmentService.core;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Appointment {
	private String appointmentId = "";
	private Date appointmentDate;
	private String appointmentDescription = "";
	
	// Constructors 
	public Appointment(String appointmentId, String appointmentDate, String appointmentDescription) {
		if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointmentId. It must be a non-null string of up to 10 characters.");
        }
        if (appointmentDate == null || isValidDate(stringToDate(appointmentDate))) {
            throw new IllegalArgumentException("Invalid appointmentDate. It must be a non-null date  of format 'DD/MM/YYYY' after today's date.");
        }
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid appointmentDescription. It must be a non-null string of up to 50 characters.");
        }
        
		this.appointmentId = appointmentId;
		this.appointmentDate = stringToDate(appointmentDate);
		this.appointmentDescription = appointmentDescription;
	}
	
	// Setters
	public void setAppointmentDate(String appointmentDate) {
		if (appointmentDate == null || isValidDate(stringToDate(appointmentDate))) {
    		throw new IllegalArgumentException("Invalid appointmentDate. It must be a non-null date of format 'DD/MM/YYYY' after today's date.");
    	} else {
    		this.appointmentDate = stringToDate(appointmentDate);
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
	public String getFormattedAppointmentDate(String appointmentId) {
		return this.dateToString(appointmentDate);
	}
	public String getAppointmentDescription(String appointmentId) {
		return this.appointmentDescription;
	}
	
	// General Methods
	public Date stringToDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse(str);
            return date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid Date Format. Please use the format 'DD/MM/YYYY'.");
        }
    }
	
	public String dateToString(Date date) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		return formattedDate.format(date);
	}
	
	public boolean isValidDate(Date date) {
		return date.before(new Date());
	}
}
