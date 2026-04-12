package InterviewProblems.DesignCache;

public class Node {

    private int key;
    private int value;

    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
