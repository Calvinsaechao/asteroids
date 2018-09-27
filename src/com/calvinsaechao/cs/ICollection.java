package com.calvinsaechao.cs;

public interface ICollection {
	/**
	 * Add a object into the collection
	 * @param o
	 */
	public void add(Object o);
	/**
	 * Retrieves the IITERATOR
	 * @return IIterator
	 */
	public IIterator getIterator();
}
