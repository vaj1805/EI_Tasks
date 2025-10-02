package TASK_2.astronaut.manager;

import TASK_2.astronaut.model.Task;
import TASK_2.astronaut.observer.Observer;
import TASK_2.astronaut.observer.Subject;

import java.util.*;
import java.io.IOException;
import java.util.logging.*;

public class ScheduleManager implements Subject {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
        try {
            FileHandler fh = new FileHandler("schedule_app.log",true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            System.err.println("Error : Could not initialize logger");
            e.printStackTrace();
        }


    }

    public static ScheduleManager getInstance() {
        if(instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }


     @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    private boolean hasConflict(Task newTask) {
        for(Task existingTask : tasks) {
            if(newTask.getStartTime().isBefore(existingTask.getEndTime()) && newTask.getEndTime().isAfter(existingTask.getStartTime())) {
                notifyObservers("Error task conflicts with existing task \"" +existingTask.getDescription());
                //logger warning
                logger.warning("Conflict detected for : " + newTask.getDescription() + " with " + existingTask.getDescription() + ".");
                return true;
            }
        }
        
        return false;
    }

    public boolean addTask(Task task) {
        if(hasConflict(task)) {
            return false;
        }
        tasks.add(task);
        Collections.sort(tasks);
        System.out.println("Task added successfully! no conflicts");
        //logger info
         logger.info("Task '" + task.getDescription() + "' added successfully.");
        return true;
    }

    public boolean removeTask(String description) {
        boolean removed = tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        if(removed) {
            System.out.println("Task removed successfully.");
            //logger. info
             logger.warning("Attempted to remove non-existent task: '" + description + "'.");
        }

        return removed;

    }

    public void viewTasks() {
        if(tasks.isEmpty()) {
            System.out.println("NO tasks scheduled");
            return;
        }

        System.out.println("\n--------Astronaut's Daily Schedule---------");
        for(Task task : tasks) {
            System.out.println(task);
        }

        System.out.println("-----------------------\n");

    }


}
