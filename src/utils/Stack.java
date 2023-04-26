package utils;

import java.util.LinkedList;

public class Stack<E> {

    private LinkedList list;

    public Stack() {
        list = new LinkedList<E>();
    }

    public void add(E element) {
        list.addFirst(element);
    }

    public E pop() {
        return (E) list.removeFirst();
    }
}