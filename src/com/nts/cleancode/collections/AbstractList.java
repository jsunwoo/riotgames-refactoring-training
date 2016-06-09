package com.nts.cleancode.collections;

public abstract class AbstractList extends AbstractCollection {

	protected Object[] elements = new Object[10];

	public Object get(int i) {
		return elements[i];
	}
}
