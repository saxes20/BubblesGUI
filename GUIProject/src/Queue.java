public class Queue<V> {

	int maxSize;
	LinkedList que;
	int nItems;	

	public Queue(int maxSize){
		this.maxSize = maxSize;
		que = new LinkedList();
	}
	
	public void insert(V j) {
		if (nItems != maxSize) {
			que.insert(que, j);
			nItems += 1; 
		//	que.printList(que);
		} else {
			remove();
			que.insert(que, j);
		}
	}// enqueue
	
	public V remove() {
		if (nItems != 0) {
			return (V) que.removeHead(que);
		}
		return null;
	}//dequeue
	
	public V get(int index) {
		if (index < nItems) {
			return (V) que.get(que, index);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public int size() {
		return nItems;
	}

}
