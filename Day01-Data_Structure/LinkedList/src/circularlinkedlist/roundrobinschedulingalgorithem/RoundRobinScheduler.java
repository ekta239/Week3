package circularlinkedlist.roundrobinschedulingalgorithem;
class RoundRobinScheduler {
    private Process head;
    private Process current;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.current = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Point to itself to make it circular
        } else {
            Process tail = head;
            while (tail.next != head) {
                tail = tail.next; // Find the last node
            }
            tail.next = newProcess; // Last node points to new process
            newProcess.next = head; // New process points to head
        }
        current = head; // Reset current to head
    }

    // Remove a process by Process ID
    public void removeProcessById(int processId) {
        if (head == null) return; // List is empty

        Process current = head;
        Process previous = null;

        do {
            if (current.processId == processId) {
                if (previous == null) { // Removing head
                    Process tail = head;
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
                    previous.next = current.next; // Bypass the current process
                }
                return; // Process removed
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void schedule() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int totalProcesses = 0;

        Process temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        // Reset current to head for scheduling
        current = head;

        while (true) {
            boolean allDone = true;
            temp = current;

            do {
                if (temp.remainingTime > 0) {
                    allDone = false; // At least one process is not done
                    int timeToExecute = Math.min(temp.remainingTime, timeQuantum);
                    temp.remainingTime -= timeToExecute;

                    // Simulate execution
                    System.out.println("Executing Process ID: " + temp.processId + " for " + timeToExecute + " units.");

                    // If the process is finished
                    if (temp.remainingTime == 0) {
                        int turnaroundTime = temp.burstTime; // Turnaround time is equal to burst time for this simple case
                        totalTurnaroundTime += turnaroundTime;
                        totalWaitingTime += (turnaroundTime - temp.burstTime);
                        System.out.println("Process ID: " + temp.processId + " completed.");
                        removeProcessById(temp.processId); // Remove the process after execution
                    }
                }
                temp = temp.next;
            } while (temp != current && temp != head);

            if (allDone) break; // Exit if all processes are done

            current = current.next; // Move to the next process
        }

        // Calculate average waiting time and turnaround time
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

        System.out.println("Average Waiting Time: " + averageWaitingTime);
     
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}