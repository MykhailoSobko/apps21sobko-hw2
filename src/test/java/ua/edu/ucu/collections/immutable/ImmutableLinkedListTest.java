package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    public ImmutableLinkedList list1;
    public ImmutableLinkedList listEmpty;

    @Before
    public void setUp() {
        list1 = new ImmutableLinkedList(new Object[] {1, 2, 3});
        listEmpty = new ImmutableLinkedList();
    }

    @Test
    public void testAdditions() {
        ImmutableLinkedList list2 = list1.addLast(1);
        assertEquals(4, list2.size());

        ImmutableLinkedList list3 = list1.addFirst(1);
        assertEquals(4, list3.size());

        ImmutableLinkedList list4 = (ImmutableLinkedList) listEmpty.addAll(0, new Object[]{1, 2, 3});
        assertEquals(1, list4.getFirst());
        assertEquals(3, list4.size());

        ImmutableLinkedList list5 = (ImmutableLinkedList) listEmpty.add(0, 1);
        assertEquals(1, list5.size());
        ImmutableLinkedList list6 = (ImmutableLinkedList) listEmpty.add(5, 1);
        assertEquals(0, list6.size());
        ImmutableLinkedList list7 = (ImmutableLinkedList) listEmpty.add(-3, 1);
        assertEquals(0, list7.size());

        ImmutableLinkedList list8 = (ImmutableLinkedList) listEmpty.addAll(new Object[]{1, 2, 3});
        assertEquals(1, list8.getFirst());
        assertEquals(3, list8.getLast());

        ImmutableLinkedList list9 = (ImmutableLinkedList) list1.addAll(new Object[]{4, 5});
        assertEquals(5, list9.getLast());

        ImmutableLinkedList list10 = (ImmutableLinkedList) list9.add(10);
        assertEquals(10, list10.getLast());

        ImmutableLinkedList list11 = (ImmutableLinkedList) list1.add(1, 100);
        assertEquals(100, list11.getHead().getNext().getValue());

        ImmutableLinkedList list12 = (ImmutableLinkedList) list11.add(1, 50);
        assertEquals(50, list12.getHead().getNext().getValue());
    }

    @Test
    public void testGet() {
        assertEquals(-1, list1.get(-1));
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list1.get(2));
        assertEquals(-1, list1.get(3));
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.remove(0);
        assertEquals(1, list1.getFirst());
        assertEquals(2, list2.getFirst());
        assertEquals(2, list2.size());

        ImmutableLinkedList list3 = (ImmutableLinkedList) listEmpty.remove(0);
        assertEquals(0, list3.size());

        ImmutableLinkedList list4 = (ImmutableLinkedList) list1.remove(1);
        assertEquals(3, list4.getHead().getNext().getValue());

        ImmutableLinkedList list5 = (ImmutableLinkedList) list1.remove(5);
        assertEquals(list1, list5);

        ImmutableLinkedList list6 = (ImmutableLinkedList) list1.remove(-5);
        assertEquals(list1, list6);

        ImmutableLinkedList list7 = (ImmutableLinkedList) (new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5, 6})).remove(3);
        assertEquals(3, list7.indexOf(5));
    }

    @Test
    public void testSet() {
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.set(0, 50);
        assertEquals(50, list2.getFirst());
        assertEquals(1, list1.getFirst());

        ImmutableLinkedList list3 = (ImmutableLinkedList) list2.set(2, 100);
        assertEquals(100, list3.getLast());
        assertEquals(3, list2.getLast());

        ImmutableLinkedList list4 = (ImmutableLinkedList) list3.set(3, 10);
        assertEquals(list3.getLast(), list4.getLast());

        ImmutableLinkedList list5 = (ImmutableLinkedList) list3.set(-1, 10);
        assertEquals(list3.getLast(), list5.getLast());

        ImmutableLinkedList list6 = (ImmutableLinkedList) listEmpty.set(0, 10);
        assertTrue(list6.isEmpty());
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list1.indexOf(1));
        assertEquals(1, list1.indexOf(2));
        assertEquals(2, list1.indexOf(3));
        assertEquals(-1, list1.indexOf(4));
        assertEquals(-1, listEmpty.indexOf(0));
    }

    @Test
    public void testSize() {
        assertEquals(3, list1.size());
        assertEquals(0, listEmpty.size());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.clear();
        assertEquals(0,list2.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list1.isEmpty());
        assertTrue(listEmpty.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] array = list1.toArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testGetHead() {
        assertEquals(1, list1.getHead().getValue());
        assertNull(listEmpty.getHead());
    }

    @Test
    public void testGetTail() {
        assertEquals(3, list1.getTail().getValue());
        assertNull(listEmpty.getTail());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, list1.getFirst());
        assertNull(listEmpty.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(3, list1.getLast());
        assertNull(listEmpty.getLast());
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList list2 = list1.removeFirst();
        assertEquals(2, list2.getFirst());

        ImmutableLinkedList list3 = listEmpty.removeFirst();
        assertNull(list3.getFirst());
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList list2 = list1.removeLast();
        assertEquals(2, list2.getLast());

        ImmutableLinkedList list3 = listEmpty.removeLast();
        assertNull(list3.getLast());
    }
}