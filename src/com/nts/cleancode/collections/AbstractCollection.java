package com.nts.cleancode.collections;

public abstract class AbstractCollection {
    protected static int INITIAL_CAPACITY = 10;
    protected Object[] elements = new Object[INITIAL_CAPACITY];
    protected boolean readOnly;
    protected int size = 0;

    public void addAll(AbstractCollection collection) {
        for (int i = 0; i < collection.size(); i++) {
            if (!contains(collection.get(i))) {
                add(collection.get(i));
            }
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element) {
        if (readOnly)
            return;

        if (shouldgorw())
            grow();

        addElement(element);

    }

    public boolean remove(Object element) {
        if (readOnly)
            return false;
        else
            for (int i = 0; i < size; i++)
                if (elements[i].equals(element)) {
                    elements[i] = null;
                    Object[] newElements = new Object[size - 1];
                    int k = 0;
                    for (int j = 0; j < size; j++) {
                        if (elements[j] != null)
                            newElements[k++] = elements[j];
                    }
                    size--;
                    elements = newElements;
                    return true;
                }
        return false;
    }

    protected boolean shouldgorw() {
        return size + 1 > capacity();
    }

    protected Object addElement(Object element) {
        return elements[size++] = element;
    }

    protected void grow() {
        Object[] newElements =
                new Object[capacity() + 10];
        for (int i = 0; i < size; i++)
            newElements[i] = elements[i];
        elements = newElements;
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(element))
                return true;
        return false;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return elements[index];
    }

    public void setReadOnly(boolean b) {
        readOnly = b;
    }

    public int capacity() {
        return elements.length;
    }
}