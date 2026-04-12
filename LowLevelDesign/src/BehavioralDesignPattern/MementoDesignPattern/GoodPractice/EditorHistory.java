package BehavioralDesignPattern.MementoDesignPattern.GoodPractice;

import java.util.Stack;

public class EditorHistory {

    private Stack<Memento> history = new Stack<>();

    public void push(Memento memento){
        history.push(memento);
    }

    public Memento pop(){
        if(!history.isEmpty()){
            return history.pop();
        }
        return null;
    }
}
