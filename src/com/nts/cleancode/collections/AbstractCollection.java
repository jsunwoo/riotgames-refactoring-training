package com.nts.cleancode.collections;

public abstract class AbstractCollection {
   protected static int INITIAL_CAPACITY = 10;
   protected Object[] elements = new Object[INITIAL_CAPACITY];
   public void addAll(AbstractCollection collection) {
      for (int i=0; i < collection.size(); i++) {
         if (!contains(collection.get(i))) {
            add(collection.get(i));
         }
      }
   }
   
   public void add(Object key, Object value) {
   }

   public abstract boolean isEmpty();

   public abstract void add(Object element);

   public abstract boolean remove(Object element);

   public abstract boolean contains(Object element);

   public abstract int size();

   public Object get(int index) {
      return elements[index];
   }
}