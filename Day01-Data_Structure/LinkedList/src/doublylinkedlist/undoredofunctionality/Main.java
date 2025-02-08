package doublylinkedlist.undoredofunctionality;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        
        editor.type("Hello");
        System.out.println("Current State: " + editor.getCurrentState()); // Hello
        
        editor.type("Hello, World!");
        System.out.println("Current State: " + editor.getCurrentState()); // Hello, World!
        
        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentState()); // Hello
        
        editor.redo();
        System.out.println("After Redo: " + editor.getCurrentState()); // Hello, World!
        
        editor.type("Hello, World! How are you?");
        System.out.println("Current State: " + editor.getCurrentState()); // Hello, World! How are you?
        
        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentState()); // Hello, World!
        
        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentState()); // Hello
        
        editor.redo();
        System.out.println("After Redo: " + editor.getCurrentState()); // Hello, World!
    }
}
