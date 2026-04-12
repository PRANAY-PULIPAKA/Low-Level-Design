package InterviewProblems.DesignCache;

public class DoubleLinkedList {

    private Node head;
    private Node tail;

    public DoubleLinkedList(){

        head =  new Node(-1,-1);
        tail =  new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node){

        node.next = head.next;
        node.prev = head;

        head.next.prev= node;
        head.next = node;
    }

    public void remove(Node node){

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public Node removeLast(){
        if(tail.prev == head){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }


}
