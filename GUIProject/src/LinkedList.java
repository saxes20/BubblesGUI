//import java.io.*; 
  
// Java program to implement 
// a Singly Linked List 
public class LinkedList<V> { 
  
    Node head; // head of list 
    
    // Method to insert a new node 
    public LinkedList insert(LinkedList list, V data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
        return list; 
    } 
    
   
    
    
    // removes the element at the specified position in this list.
    public boolean remove(LinkedList list,int index) {
        
        if (index == 0) {
            list.removeHead(list);
        }
 
        // if the index is out of range, exit
        if (index < 1 || index > getSize(list)) {
            return false;
        }
 
        Node currNode = list.head;
        if (head != null) {
            for (int i = 0; i < index-1; i++) {
                if (currNode.getNext() == null)
                    return false;
 
                currNode = currNode.getNext();
            }
            //System.out.println("data: " + currNode.data);
            currNode.setNext(currNode.getNext().getNext());
 
            // decrement the number of elements variable
            
            return true;
 
        }
        return false;
    }
    
    
    public int getSize(LinkedList list) {
        
         if (list.head == null) { 
            return 0; 
        } 
        
        Node currNode = list.head;
        
        int length = 1; 
        
        while (currNode.getNext() != null) {
            length += 1;
            currNode = currNode.getNext();
        }
        
        return length; 
     
    }
    
    
    public boolean printList(LinkedList list) {
        String line = "[";
        
        if (list.head == null) { 
            System.out.println("");
            return false; 
        } 
        
        Node currNode = list.head;
        line += String.valueOf(currNode.data);
        
        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
            line += ", ";
            line += String.valueOf(currNode.data);
            
        }
        
        line += "]";
        
        System.out.println(line);
        
        return false;
    }
    
    public V get(LinkedList list, int index) {
        Node currNode = list.head;
        int size = list.getSize(list); 
        if (index == 0) { return (V)currNode.data; }
        if (index >= size) {return (V)"Index out of range"; }
        for (int i=1; i <= index; i++) {
            currNode = currNode.getNext();
        }
        return (V)currNode.data; 
    }
    
    public int find(LinkedList list, V data) {
        Node currNode = list.head;
        int size = list.getSize(list); 
        for (int i=0; i < size; i++) {
            if (data.equals(currNode.data)) {
                return i; 
            }
            currNode = currNode.getNext();
        }
        return -1; 
    }
    
    public void addFirst (LinkedList list, V data) {
        Node first = new Node(data); 
        first.next = list.head;
        list.head = first; 
    }
    
    public V removeHead (LinkedList list) {
    		V send = (V) list.head.data;
        Node second = list.head.getNext();
        list.head = second; 
        return send;
    }
   
}