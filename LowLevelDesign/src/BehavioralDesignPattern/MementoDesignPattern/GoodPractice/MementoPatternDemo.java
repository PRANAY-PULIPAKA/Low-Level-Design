package BehavioralDesignPattern.MementoDesignPattern.GoodPractice;

public class MementoPatternDemo {

    public static void main(String[] args) {
        TextEditor editor =  new TextEditor();
        EditorHistory history = new EditorHistory();

        //Initial Text
        editor.setText("Hello");
        System.out.println("Current Text: " + editor.getText() );
        history.push(editor.save());

        //userTypes something new

        editor.setText("Hello world!!");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());

        //another change
        editor.setText("Hello, World! Welcome to Memento Pattern.");
        System.out.println("Current Text: " + editor.getText());

        //undo
        Memento previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After undo, text: " + editor.getText());

        // Undo to the initial state
        previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After second undo, text: " + editor.getText());
    }
}
