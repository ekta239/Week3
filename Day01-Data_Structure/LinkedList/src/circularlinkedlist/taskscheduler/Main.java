package circularlinkedlist.taskscheduler;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addTaskAtEnd(1, "Task 1", 2, new Date());
        scheduler.addTaskAtEnd(2, "Task 2", 1, new Date());
        scheduler.addTaskAtBeginning(3, "Task 3", 3, new Date());
        
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();
        
        System.out.println("\nCurrent Task:");
        Task currentTask = scheduler.viewCurrentTask();
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + ", Task Name: " + currentTask.taskName);
        }
        
        scheduler.moveToNextTask();
        System.out.println("\nNext Task:");
        currentTask = scheduler.viewCurrentTask();
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + ", Task Name: " + currentTask.taskName);
        }
        
        System.out.println("\nSearching for tasks with priority 1:");
        scheduler.searchTaskByPriority(1);
        
        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);
        
        System.out.println("All Tasks after removal:");
        scheduler.displayAllTasks();
    }
}
