package com.nts.cleancode.collections;

public abstract class AbstractSet extends AbstractCollection {

	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];

	public Object get(int index) {
		return elements[index];
	}
}
