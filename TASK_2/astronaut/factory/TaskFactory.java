package TASK_2.astronaut.factory;
import TASK_2.astronaut.model.*;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        try {
            return new Task(description, startTime, endTime, priority);
        } catch (IllegalArgumentException e) { 
            System.err.println("Error : " + e.getMessage());
            return null;
        }
    }
}
