package ru.itis;

/**
 * 05.07.2019
 * TreeBstImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {
    static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }
    }

    // корень
    private Node<T> root;


    @Override
    public void insert(T value) {
        this.root = insert(root, value);
    }

    // вставить новый элемент value в дерево с корнем в root
    // и вернуть этот корень
    private Node<T> insert(Node<T> root, T value) {
        // если корня нет - значит здесь должен быть элемент
        if (root == null) {
            root = new Node<>(value);
        } else if (value.compareTo(root.value)  <= 0) {
            // если новое значение оказалось меньше или равно корню
            // вставляем в левое поддерево
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(Node<T> root) {
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.value + " ");
        if (root.right != null) {
            print(root.right);
        }
    }

    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> root, T value) {
        if (root != null) {
            if (root.value.compareTo(value) == 0) {
                return true;
            } else if (root.value.compareTo(value) > 0) {
                return contains(root.left, value);
            } else {
                return contains(root.right, value);
            }
        } else return false;
    }

    // TODO: реализовать
    @Override
    public void printByLevels() {

    }

    // TODO: реализовать
    @Override
    public boolean isBst() {
        return false;
    }
}
