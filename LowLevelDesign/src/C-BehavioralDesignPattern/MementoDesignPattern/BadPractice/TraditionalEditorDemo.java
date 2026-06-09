package BehavioralDesignPattern.MementoDesignPattern.BadPractice;

public class TraditionalEditorDemo {

    public static void main(String[] args) {
        TextEditorTraditional editor =  new TextEditorTraditional("Hello");
        editor.showText(); //output Hello;

        String backUp = "Hello" ;// manually keeping the backup
        editor.setText("Hello, world!!");
        editor.showText();

        editor.undo(backUp);
        editor.showText();
    }
}
