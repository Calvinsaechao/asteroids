package com.calvinsaechao.cs;

public interface IMovable {
	/**
	 * Moves the IMOVABLE object
	 */
	public void move();
	/**
	 * Sets the speed of the object
	 * @param speed
	 */
	public void setSpeed(int speed);
	/**
	 * Retrieves the speed of the object
	 * @return int
	 */
	public int getSpeed();
}
