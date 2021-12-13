package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] items;
    private final int size;

    public ImmutableArrayList(Object[] elements) {
        items = elements.clone();
        size = elements.length;
    }

    public ImmutableArrayList() {
        items = new Object[] {};
        size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArray = new Object[size + c.length];
        System.arraycopy(this.items, 0, newArray, 0, size);
        System.arraycopy(c, 0, newArray, size, c.length);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > size) {
            return this;
        }
        Object[] newItems = new Object[size + c.length];
        System.arraycopy(items, 0, newItems, 0, index);
        System.arraycopy(c, 0, newItems, index, c.length);
        System.arraycopy(items, index, newItems,
                index + c.length, size - index);

        return new ImmutableArrayList(newItems);
    }

    @Override
    public Object get(int index) {
        if (indexIsInvalid(index)) {
            return null;
        }
        return items[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (indexIsInvalid(index)) {
            return this;
        }
        Object[] newItems = new Object[size - 1];
        System.arraycopy(items, 0, newItems, 0, index);
        System.arraycopy(items, index + 1,
                newItems, index, size - index - 1);

        return new ImmutableArrayList(newItems);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (indexIsInvalid(index)) {
            return this;
        }

        Object[] newItems = new Object[size];
        System.arraycopy(items, 0, newItems, 0, size);
        newItems[index] = e;

        return new ImmutableArrayList(newItems);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (items[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(items, 0, arr, 0, size);
        return arr;
    }

    private boolean indexIsInvalid(int index) {
        return index < 0 || index >= size;
    }
}
