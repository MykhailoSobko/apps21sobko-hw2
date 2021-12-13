
package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    public Node node1;
    public Node node2;
    public Node node3;

    @Before
    public void setUp() {
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node1.setNext(node2);
        node1.setPrevious(node3);
    }

    @Test
    public void testToString() {
        assertEquals("1", node1.toString());
        assertEquals("2", node2.toString());
        assertEquals("3", node3.toString());
    }

    @Test
    public void testGetPrevious() {
        assertEquals(node3, node1.getPrevious());
    }

    @Test
    public void testSetPrevious() {
        Node newNode = new Node(4);
        node1.setPrevious(newNode);
        assertEquals(newNode, node1.getPrevious());
    }

    @Test
    public void testGetValue() {
        assertEquals(1, node1.getValue());
        assertEquals(2, node2.getValue());
        assertEquals(3, node3.getValue());
    }

    @Test
    public void testSetValue() {
        node1.setValue(10);
        assertEquals(10, node1.getValue());
    }

    @Test
    public void testGetNext() {
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void testSetNext() {
        Node newNode = new Node(4);
        node1.setNext(newNode);
        assertEquals(newNode, node1.getNext());
    }
}