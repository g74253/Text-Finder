package estructuras;
/*
 * Estructura de lista enlazada.
 * Source: github del profesor 
 * @author Gretchell 
 */
public class LinkedList {
	private Node head;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(Object data) {
        Node newBNode = new Node(data);
        newBNode.next = this.head;
        this.head = newBNode;
        this.size++;
    }
    public void insertLast(Object data) {
    	Node current = this.head;
    	Node aux = new Node(data);
    	while (current.getNext() != null) {
    		current = current.getNext();
    	}
    	current.setNext(aux);
    	this.size++;
    	}
    
    public Node deleteFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    public void delist() {
    	 Node aux = this.head;
    	 Node current = this.head;
    	 LinkedList n = new LinkedList();
    	 while (current.getData().getClass()!= n.getClass()) {
    		 aux = current;
    		 current = current.getNext();
    	}
    	 if (current == this.head) {
             this.head = this.head.getNext();
         } else {
             aux.setNext(current.getNext());
         }
    	this.size--;
    	
    }
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    public Node find(String searchValue) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }
    public Node delete(String searchValue) {
        Node current = this.head;
        Node previous = this.head;

        while (current != null) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    this.head = this.head.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return current;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }
    public Node position (int value) {
    	Node current = this.head;
    	int count = 0;
    	while(current != null) {
    		if (count == value)
    			return current;
    		else {
    			count++;
    			current = current.getNext();
    		}
    	}
    	return null;
    }
    public void insertl() {
    	Node current = this.head;
    	LinkedList n = new LinkedList();
    	while (current != null) {
    		if (current.getData().getClass() == n.getClass()) {
    			this.delist();
    			for (int i = 0; i < ((LinkedList) current.getData()).size(); i++) {
    				this.insertLast(((LinkedList) current.getData()).position(i).getData());
    				
    			}
    		} current = current.getNext();
    	}
    }
    public void swap(int i,int j) {
    	if(i != j) {
    	Node current1 = this.position(i);
    	Node current2 = this.position(j);
    	Node current1aux = null;
    	if (i != 0) {
    		current1aux = this.position(i-1);}
    	else {
    		current1aux = this.position(i);
    	}
    	Node current2aux = this.position(j-1);
    	if (i != 0) {
    		Node aux = current2.getNext();
    		current1aux.setNext(current2);
    		current2aux.setNext(current1);
    		current2.setNext(current1.getNext());
    		current1.setNext(aux);
    	}else {
    		Node aux = current2.getNext();
    		this.head = current2;
    		current2aux.setNext(current1);
    		current2.setNext(current1.getNext());
    		current1.setNext(aux);
    		
    	}}
    }
    
}
