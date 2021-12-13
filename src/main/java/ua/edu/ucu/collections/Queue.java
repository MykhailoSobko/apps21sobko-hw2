package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList items = new ImmutableLinkedList();

    public Queue() { }

    public Object peek() {
        return items.getFirst();
    }

    public Object dequeue() {
        Object toReturn = peek();
        items = items.removeFirst();
        return toReturn;
    }

    public void enqueue(Object e) {
        items = (ImmutableLinkedList) items.add(e);
    }
}