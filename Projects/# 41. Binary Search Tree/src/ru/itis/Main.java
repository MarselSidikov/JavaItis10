package ru.itis;

public class Main {

    public static void main(String[] args) {
	    int elements[] = {3, 8, 1, 4, 9, 22, 15};
	    Tree<Integer> tree = new TreeBstImpl<>();

	    for (int element : elements) {
	        tree.insert(element);
        }

        int i = 0 ;

	    tree.print();

        System.out.println(tree.contains(1));
        System.out.println(tree.contains(50));
    }
}
