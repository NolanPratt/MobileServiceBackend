package TaskService.core;

public class Task {
	private String taskId = "";
	private String taskName = "";
	private String taskDescription = "";
	
	// Constructors
	public Task(String taskId, String taskName, String taskDescription) {
		if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid taskId. It must be a non-null string of up to 10 characters.");
        }
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid taskName. It must be a non-null string of up to 20 characters.");
        }
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid taskDescription. It must be a non-null string of up to 50 characters.");
        }
        
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	// Setters
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid taskName. It must be a non-null string of up to 20 characters.");
    	} else {
    		this.taskName = taskName;
    	}
	}
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid taskDescription. It must be a non-null string of up to 50 characters.");
    	} else {
    		this.taskDescription = taskDescription;
    	}
	}
	
	//Getters
	public String getTaskId() {
		return this.taskId;
	}
	public String getTaskName(String taskId) {
		return this.taskName;
	}
	public String getTaskDescription(String taskId) {
		return this.taskDescription;
	}
}
