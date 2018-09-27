package com.calvinsaechao.cs;

import java.util.ArrayList;

public class SpaceCollection implements ICollection {
	private ArrayList<GameObject> store;
	public SpaceCollection() {
		store = new ArrayList<GameObject>();
	}
	/**
	 * Remove a object from the collection
	 * @param o
	 */
	public void remove(Object o) {
		store.remove(o);
	}
	/**
	 * Add an object to the collection
	 */
	public void add(Object o) {
		store.add((GameObject)o);
	}
	/**
	 * Retrieves the IITERATOR
	 * @return IIterator
	 */
	public IIterator getIterator() {
		return new storeIterator();
	}
	private class storeIterator implements IIterator {
		private int currElementIndex;
		public storeIterator() {
			currElementIndex = -1;
		}
		/**
		 * Checks if there is another element in the collection
		 * @return boolean
		 */
		public boolean hasNext() {
			if(store.size() <= 0) return false;
			if(currElementIndex == (store.size()-1))
				return false;
			return true;
		}
		/**
		 * Retrieves the next element in the collection
		 * @return Object
		 */
		public Object getNext() {
			currElementIndex++;
			return(store.get(currElementIndex));
		}

	}
}
