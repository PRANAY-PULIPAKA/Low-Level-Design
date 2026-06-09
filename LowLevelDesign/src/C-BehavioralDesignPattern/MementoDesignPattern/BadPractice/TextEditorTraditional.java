package BehavioralDesignPattern.MementoDesignPattern.BadPractice;

public class TextEditorTraditional {

    private String text;

    public TextEditorTraditional(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public void undo(String previousText){
        this.text = previousText;
    }

    public void showText(){
        System.out.println("Current text: "+ text);
    }
}
