package circularlinkedlist.roundrobinschedulingalgorithem;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time quantum of 4 units

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial Process List:");
        scheduler.displayProcesses();

        System.out.println("\nScheduling Processes:");
        scheduler.schedule();

        System.out.println("\nFinal Process List:");
        scheduler.displayProcesses();
    }

}
