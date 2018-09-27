package com.calvinsaechao.cs;

import com.codename1.ui.geom.Point2D;

public abstract class MovableObject extends GameObject implements IMovable {
	private int speed;
	private int direction;
	public MovableObject(){
		super();
		speed = Rand.getRandom().nextInt(10+1);
		direction = Rand.getRandom().nextInt(359+1);
	}
	/**
	 * Retrieves the speed
	 * @return int
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * Retrieves the direction
	 * @return int
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 * Set the speed
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * set the Direction
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	/**
	 * Move the object according to its speed and direction by one increment of time
	 */
	public void move() {
		int dir = 90 - direction;
		Point2D loc = super.getLoc();
		int deltaX = (int)(Math.cos(dir)*speed) + (int)loc.getX();
		int deltaY = (int)(Math.sin(dir)*speed) + (int)loc.getY();
		super.setLoc(new Point2D(deltaX, deltaY));
	}
}
