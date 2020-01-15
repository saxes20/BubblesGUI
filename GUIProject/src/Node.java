public class Node<V>
{
    V data; 
    Node next;

    Node(V d){
        data = d;
        next = null;

    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }

}