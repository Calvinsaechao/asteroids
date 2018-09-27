package com.calvinsaechao.cs;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Missile extends MovableObject {
	private int fuelLevel;
	public Missile(int speed, Point2D loc, int direction) {
		fuelLevel = 10;
		super.setColor(ColorUtil.GRAY);
		super.setDirection(direction);
		super.setLoc(loc);
		super.setSpeed(speed);
	}
	/**
	 * Drain the fuel level by one and checks if the fuel level is zero
	 * @return boolean
	 */
	public boolean drainFuel() {
		if(fuelLevel > 0) {
			fuelLevel--;
			return true;
		}
		return false;
	}
	/**
	 * Moves the missile and drains its fuel
	 */
	public void move() {
		super.move();
		drainFuel();
	}
	/**
	 * Retrieves the fuel level
	 * @return int
	 */
	public int getFuel() {
		return fuelLevel;
	}
	public String toString() {
		return "[Missile        |Location: "+super.getLoc()+"|Color: "+super.getColor()+"|Speed: "+super.getSpeed()+"|Direction "+super.getDirection()+
				"|Fuel Level: "+fuelLevel+"]";
	}
}
