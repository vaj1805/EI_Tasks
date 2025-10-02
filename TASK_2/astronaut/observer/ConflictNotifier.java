package TASK_2.astronaut.observer;

public class ConflictNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ALERT: " + message);
    }
}
