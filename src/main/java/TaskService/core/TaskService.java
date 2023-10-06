package TaskService.core;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	private List<Task> taskList = new ArrayList<>();
	
	// Constructor
	public TaskService() {
		
	}
	
	public List<Task> getTaskList() {
		return this.taskList;
	}
	
	// Add a new Task to the Task list
	public void addTask(Task task) {
		if (taskExists(task)) {
	        throw new IllegalArgumentException("Error: Duplicate Task. Task with ID " + task.getTaskId() + " already exists.");
	    } else {
	        taskList.add(task);
	    }
	}
	
	// Check whether a Task already exists within the Task list
	public boolean taskExists(Task task) {
		for (Task tasks : taskList) {
			if (tasks.getTaskId().equals(task.getTaskId())) {
				return true;
			}
		}
		return false;
	}
	
	// Iterate through the Task list and delete the Task object with a matching Id
	public void deleteTask(String taskId) {
		for (Task task : taskList) {
			if (task.getTaskId().equals(taskId)) {
				taskList.remove(task);
				return;
			}
		}
		throw new IllegalArgumentException("Deletion Unsuccessful: Task Id not found.");
	}
	
	// Update a Task's specified field to a new value
	public void updateTask(String taskId, String fieldToUpdate, String newValue) {
		for (Task task : taskList) {
			if (task.getTaskId().equals(taskId)) {
				switch (fieldToUpdate) {
			    case "Task Id":
			    	throw new IllegalArgumentException("Invalid Field: " + fieldToUpdate + " is immutable.");
			    case "Task Name":
			    	task.setTaskName(newValue);
			    	System.out.println("Update Success: Task Name Changed.");
			        return;
			    case "Task Description":
			    	task.setTaskDescription(newValue);
			    	System.out.println("Update Success: Task Description Changed.");
			    	return;
			    default:
			        throw new IllegalArgumentException("Invalid Field: " + fieldToUpdate + " is not a valid field.");
				}
			}
		}
		throw new IllegalArgumentException("Update Unsuccessful: Task Id " + taskId + " not found.");
	}
}
