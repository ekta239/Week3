package circularlinkedlist.taskscheduler;
import java.util.Date;
class TaskScheduler {
    private Task head;
    private Task current;

    public TaskScheduler() {
        this.head = null;
        this.current = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Point to itself to make it circular
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next; // Find the last node
            }
            newTask.next = head; // New task points to head
            tail.next = newTask; // Last node points to new task
            head = newTask; // Update head to new task
        }
        current = head; // Set current to the new head
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Point to itself to make it circular
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next; // Find the last node
            }
            tail.next = newTask; // Last node points to new task
            newTask.next = head; // New task points to head
        }
        current = head; // Reset current to head
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Point to itself to make it circular
        } else if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        } else {
            Task current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
                if (current == head) break; // Loop back to head
            }
            newTask.next = current.next; // New task points to the next node
            current.next = newTask; // Current node points to new task
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) return; // List is empty

        Task current = head;
        Task previous = null;

        do {
            if (current.taskId == taskId) {
                if (previous == null) { // Removing head
                    Task tail = head;
                    while (tail.next != head) {
                        tail = tail.next; // Find the last node
                    }
                    if (tail == head) { // Only one node
                        head = null;
                    } else {
                        head = head.next; // Move head to next
                        tail.next = head; // Last node points to new head
                    }
                } else {
                    previous.next = current.next; // Bypass the current task
                }
                return; // Task removed
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    // View the current task
    public Task viewCurrentTask() {
        return current;
    }

    // Move to the next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task - ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}