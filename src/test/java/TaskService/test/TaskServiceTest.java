package TaskService.test;

import TaskService.core.Task;
import TaskService.core.TaskService;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {
	private TaskService service;

    @Before
    public void setUp() {
        service = new TaskService();
    }
    
    @After
    public void tearDown() {
    	service = null;
    }

    @Test
    public void testTaskListCreation() {
    	assertEquals(0, service.getTaskList().size()); // The task list should now be size 0
    }
    
    // Testing the task addition method
    @Test
    public void testTaskListInsertion() {
    	Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
    	
        service.addTask(task);
        
        assertEquals(1, service.getTaskList().size()); // The task list should now be size 1
    }

    @Test
    public void testAddDuplicateTask() {
        Task task1 = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        Task task2 = new Task("1", "Wash Clothes", "Wash dirty clothes in washer.");

        service.addTask(task1);
        service.addTask(task2);

        assertEquals(1, service.getTaskList().size()); // Only one task should be added
    }
    
    // Testing the task delete method
    @Test
    public void testDeleteTask() {
    	Task task1 = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        Task task2 = new Task("2", "Wash Clothes", "Wash dirty clothes in washer.");

        service.addTask(task1);
        service.addTask(task2);

        service.deleteTask(task1.getTaskId());

        assertEquals(1, service.getTaskList().size()); // Only one task should be left
        assertEquals("2", service.getTaskList().get(0).getTaskId()); // The final task's Id should be 2
    }
    
    @Test
    public void testInvalidDeleteTask() {
    	Task task1 = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        Task task2 = new Task("2", "Wash Clothes", "Wash dirty clothes in washer.");

        service.addTask(task1);
        service.addTask(task2);

        service.deleteTask("3");

        assertEquals(2, service.getTaskList().size()); // No tasks should be deleted
    }
    
    // Testing the task update method
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskId() {
        Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        service.addTask(task);

        // Update the task's id
        service.updateTask("1", "Task Id", "2");
    }
    
    @Test
    public void testUpdateTaskName() {
        Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        service.addTask(task);

        // Update the task's name
        service.updateTask("1", "Task Name", "Change Outfit");

        Task updatedTask = service.getTaskList().get(0);
        assertEquals("Change Outfit", updatedTask.getTaskName(updatedTask.getTaskId())); // The task's name should now be Change Outfit instead of Change Clothes
    }
    
    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        service.addTask(task);

        // Update the task's description
        service.updateTask("1", "Task Description", "Change current clothes to new ones.");

        Task updatedTask = service.getTaskList().get(0);
        assertEquals("Change current clothes to new ones.", updatedTask.getTaskDescription(updatedTask.getTaskId())); // The task's description should now be changed
    }
    
    @Test
    public void testUpdateInvalidTaskId() {
        Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        service.addTask(task);

        // Update the task's description
        service.updateTask("2", "Task Description", "Change current clothes to new ones.");

        Task updatedTask = service.getTaskList().get(0);
        assertEquals("Remove clothes and put on new clothes.", updatedTask.getTaskDescription(updatedTask.getTaskId())); // The task's description should be unchanged
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskUpdate() {
        Task task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
        service.addTask(task);
        service.updateTask("1", "task 1 id", "2");
    }
}
