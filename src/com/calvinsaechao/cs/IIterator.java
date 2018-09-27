package com.calvinsaechao.cs;

public interface IIterator {
	/**
	 * Checks if there is another element in the collection
	 * @return boolean
	 */
	public boolean hasNext();
	/**
	 * Retrieves the next element in the collection
	 * @return Object
	 */
	public Object getNext();
}
