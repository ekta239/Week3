package doublylinkedlist.undoredofunctionality;

class TextEditor {
    private TextState currentState;
    private int historySize;
    private int currentSize;
    private TextState head;
    private TextState tail;

    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.head = null;
        this.tail = null;
        this.currentState = null;
    }

    public void type(String newText) {
        // Create a new state
        TextState newState = new TextState(newText);
        
        // If we have reached the history limit, remove the oldest state
        if (currentSize == historySize) {
            head = head.next; // Move head to the next state
            if (head != null) {
                head.prev = null; // Remove the link to the old head
            }
            currentSize--;
        }

        // Add the new state to the end of the list
        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        } else {
            head = newState; // If it's the first state
        }
        
        tail = newState; // Update tail to the new state
        currentState = newState; // Set current state to the new state
        currentSize++;
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev; // Move to the previous state
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next; // Move to the next state
        }
    }

    public String getCurrentState() {
        return currentState != null ? currentState.text : "";
    }
}