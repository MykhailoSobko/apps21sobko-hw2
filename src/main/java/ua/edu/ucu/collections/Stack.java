package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList items = new ImmutableLinkedList();

    public Stack() { }

    public void push(Object e) {
        items = (ImmutableLinkedList) items.add(e);
    }

    public Object pop() {
        Object toReturn = peek();
        items = items.removeLast();
        return toReturn;
    }

    public Object peek() {
        return items.getLast();
    }
}
