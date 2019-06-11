package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Node a = new Node(1);
	    Node b = new Node(2);
	    Node c = new Node(3);
	    Node d = new Node(4);
	    Node e = new Node(5);
	    Node f = new Node(6);
	    Node g = new Node(7);
	    Node h = new Node(8);

	    a.setNext(b);
	    b.setNext(c);
	    c.setNext(d);
	    d.setNext(e);
	    e.setNext(f);
	    f.setNext(g);
	    g.setNext(h);

	    Node current = a;

	    while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}
    }
}
