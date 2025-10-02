package TASK_2.astronaut.model;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean isCompleted;

    public Task(String description, String startTimeStr, String endTimeStr, String priority) {
        this.description = description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            this.startTime = LocalTime.parse(startTimeStr,formatter);
            this.endTime = LocalTime.parse(endTimeStr,formatter);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid format. Please give in HH:mm format");
        }

        if(endTime.isBefore(startTime) || endTime.equals(startTime)) {
            throw new IllegalArgumentException("End time must be before start time.");
        }

        this.priority = priority;
        this.isCompleted = false;

    }

    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String status = isCompleted ? "Completed" : "Pending";
        return String.format("%s - %s: %s [%s] - Status: %s",
        startTime.format(formatter),
        endTime.format(formatter),
        description,
        priority,
        status
        );
    }

    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(endTime);
    }




}
