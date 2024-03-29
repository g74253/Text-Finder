package estructuras;

/*
 * Estructura del nodo que se usa en la lista enlazada.
 * Source: github del profesor 
 * @author Gretchell 
 */

public class Node {
	private Object data;
    public Node next;

    public Node(Object data) {
        this.next = null;
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return this.data;
    }
    public Node getNext() {

        return this.next;
    }

    public void setNext(Node BNode) {

        this.next = BNode;
    }
}
