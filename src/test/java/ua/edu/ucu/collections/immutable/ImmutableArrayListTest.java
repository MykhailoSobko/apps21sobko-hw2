package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    public ImmutableArrayList array1;
    public ImmutableArrayList arrayEmpty;

    @Before
    public void setUp() {
        array1 = new ImmutableArrayList(new Object[] {1, 2, 3});
        arrayEmpty = new ImmutableArrayList();
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList array2 = (ImmutableArrayList) array1.addAll(new Object[] {4, 5, 6});
        assertNotEquals(array1.getItems(), array2.getItems());

        ImmutableArrayList array3 = (ImmutableArrayList) array1.addAll(0, new Object[]{4, 5, 6});
        assertEquals(array2.size(), array3.size());

        ImmutableArrayList array4 = (ImmutableArrayList) arrayEmpty.add(1);
        assertArrayEquals(new Object[]{1}, array4.getItems());

        ImmutableArrayList array5 = (ImmutableArrayList) arrayEmpty.addAll(-1, new Object[]{1});
        assertArrayEquals(array5.getItems(), arrayEmpty.getItems());

        ImmutableArrayList array6 = (ImmutableArrayList) arrayEmpty.add(3,1);
        assertArrayEquals(array6.getItems(), arrayEmpty.getItems());
    }

    @Test
    public void testGet() {
        ImmutableArrayList array2 = (ImmutableArrayList) array1.addAll(new Object[]{4, 5, 6});
        assertEquals(1, array1.get(0));
        assertEquals(1, array2.get(0));

        assertNull(array1.get(3));
        assertNull(array1.get(-1));
        assertEquals(4, array2.get(3));
    }

    @Test
    public void testRemove() {
        ImmutableArrayList array2 = (ImmutableArrayList) array1.remove(0);
        assertEquals(2, array2.size());

        ImmutableArrayList array3 = (ImmutableArrayList) array2.remove(2);
        assertArrayEquals(array2.getItems(), array3.getItems());
    }

    @Test
    public void testSet() {
        ImmutableArrayList array2 = (ImmutableArrayList) array1.set(0, 100);
        assertEquals(100, array2.get(0));
        assertEquals(1, array1.get(0));

        ImmutableArrayList array3 = (ImmutableArrayList) arrayEmpty.set(0, 100);
        assertArrayEquals(array3.getItems(), arrayEmpty.getItems());
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, array1.indexOf(1));
        assertEquals(-1, array1.indexOf(100));
    }

    @Test
    public void testSize() {
        assertEquals(3, array1.size());
        assertEquals(0, arrayEmpty.size());
    }

    @Test
    public void testClear() {
        ImmutableArrayList array2 = (ImmutableArrayList) array1.clear();
        assertArrayEquals(array2.getItems(), arrayEmpty.getItems());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(array1.isEmpty());
        assertTrue(arrayEmpty.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(array1.getItems(), array1.toArray());
        assertArrayEquals(arrayEmpty.getItems(), arrayEmpty.toArray());
    }
}