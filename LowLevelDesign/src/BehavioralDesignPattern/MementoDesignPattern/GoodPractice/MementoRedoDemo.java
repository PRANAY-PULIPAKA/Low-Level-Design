package BehavioralDesignPattern.MementoDesignPattern.GoodPractice;

public class MementoRedoDemo {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistoryExtended history = new EditorHistoryExtended();
        // Initial state
        editor.setText("Hello");
        history.saveState(editor.save());
        // First change
        editor.setText("Hello, World!");
        history.saveState(editor.save());
        // Second change
        editor.setText("Hello, World! Welcome!");
        System.out.println("Current: " + editor.getText());
        // Undo the last change
        Memento previousState = history.undo(editor.save());
        if (previousState != null) {
            editor.restore(previousState);
            System.out.println("After undo: " + editor.getText());
        }
        // Redo the undone change
        Memento redoState = history.redo(editor.save());
        if (redoState != null) {
            editor.restore(redoState);
            System.out.println("After redo: " + editor.getText());
        }
    }
}


