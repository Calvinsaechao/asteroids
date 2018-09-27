package com.calvinsaechao.cs;

public abstract class FixedObject extends GameObject {
	private static int id;
	public FixedObject() {
		super();
		
	}
	/**
	 * Retrieves the ID number of the object
	 * @return int
	 */
	public static int getId() {
		return id;
	}
}
