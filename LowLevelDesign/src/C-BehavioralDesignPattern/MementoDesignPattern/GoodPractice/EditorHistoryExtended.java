package BehavioralDesignPattern.MementoDesignPattern.GoodPractice;

import java.util.Stack;

public class EditorHistoryExtended {
    private Stack<Memento> undoStack =  new Stack<>();
    private Stack<Memento> redoStack =  new Stack<>();

    public void saveState(Memento memento){
        undoStack.push(memento);
        redoStack.clear();
    }

    public Memento undo(Memento currentState){
        if(!undoStack.isEmpty()){
            redoStack.push(currentState);
            return undoStack.pop();
        }
        return null;
    }


    public Memento redo(Memento currentState){
        if(!redoStack.isEmpty()){
            undoStack.push(currentState);
            return redoStack.pop();
        }

        return null;

    }
}
