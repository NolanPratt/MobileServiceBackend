package TaskService.test;

import TaskService.core.Task;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
	private Task task;

    @Before
    public void setUp() {
        task = new Task("1", "Change Clothes", "Remove clothes and put on new clothes.");
    }

    
    // Testing valid Task definitions
    @Test
    public void testValidTaskCreation() {
        assertNotNull(task);
    }

    @Test
    public void testValidTaskId() {
        assertEquals("1", task.getTaskId());
    }
    
    @Test
    public void testValidTaskName() {
        assertEquals("Change Clothes", task.getTaskName(task.getTaskId()));
    }

    @Test
    public void testValidTaskDescription() {
        assertEquals("Remove clothes and put on new clothes.", task.getTaskDescription(task.getTaskId()));
    }

    
    // Testing null attributes
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskCreation() {
        new Task(null, null, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskId() {
        new Task(null, "Change Clothes", "Remove clothes and put on new clothes.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskName() {
        new Task("1", null, "Remove clothes and put on new clothes.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskDescription() {
        new Task("1", "Change Clothes", null);
    }
    
    
    // Testing satisfaction of attribute length
    @Test(expected = IllegalArgumentException.class)
    public void testValidTaskIdLength() {
        new Task("65165132165162161165", "Change Clothes", "Remove clothes and put on new clothes.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidTaskNameLength() {
        new Task("1", "Remove clothes and put on new clothes", "Remove clothes and put on new clothes.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTaskNameLength() {
        task.setTaskName("Remove clothes and put on new clothes");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTaskName() {
        task.setTaskName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidTaskDescriptionLength() {
        new Task("1", "Change Clothes", "Remove the current clothing items from body and put new clothing items on body.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTaskDescriptionLength() {
        task.setTaskDescription("Remove the current clothing items from body and put new clothing items on body.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTaskDescription() {
        task.setTaskDescription(null);
    }
}