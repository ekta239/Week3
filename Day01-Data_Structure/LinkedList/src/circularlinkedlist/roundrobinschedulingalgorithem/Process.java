package circularlinkedlist.roundrobinschedulingalgorithem;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Remaining time starts as the burst time
        this.priority = priority;
        this.next = null;
    }
}