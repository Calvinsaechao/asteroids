package com.calvinsaechao.cs;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class PlayerShip extends MovableObject implements ISteerable{
	private int missileCount;
	private MissileLauncher missileLauncher;
	
	public PlayerShip() {
		super.setColor(ColorUtil.WHITE);
		super.setLoc(new Point2D(GameWorld.getWidth()/2,GameWorld.getHeight()/2));
		super.setDirection(0);
		super.setSpeed(0);
		missileCount = 10;
		missileLauncher = new MissileLauncher(super.getLoc());
	}
	/**
	 * Deduct the missileCount by one and checks if the missle count is zero
	 * @return boolean
	 */
	public boolean fireMissile() {
		if (missileCount == 0) {
			System.out.println("Insufficient missiles");
			return false;
		}
		else {
			missileCount--;
			return true;
		}
	}
	/**
	 * Reloads the missile count
	 */
	public void reloadMissiles() {
		missileCount = 10;
	}
	/**
	 * Retrieves the missile count
	 * @return int
	 */
	public int getMissileCount() {
		return missileCount;
	}
	/**
	 * Turns the PLAYERSHIP to the left by one degree
	 */
	public void turnLeft() {
		int direction = super.getDirection();
		if(direction == 0)
			super.setDirection(359);
		else
			super.setDirection(direction-1);
	}
	/**
	 * Turns the PLAYERSHIP to the right by one degree
	 */
	public void turnRight() {
		int direction = super.getDirection();
		if(direction == 359)
				super.setDirection(0);
		else
			super.setDirection(direction+1);
	}
	/**
	 * Retrieves the missile launcher from PLAYERSHIP
	 * @return MissileLauncher
	 */
	public MissileLauncher getMissileLauncher() {
		return missileLauncher;
	}
	/**
	 * Moves the missile launcher with the PLAYERSHIP
	 */
	public void move() {
		super.move();
		missileLauncher.setLoc(super.getLoc());
	}
	public String toString() {
		return "[PlayerShip     |Location: "+super.getLoc()+"|Color: "+super.getColor()+"|Speed: "+super.getSpeed()+"|Direction "+super.getDirection()
				+ "|Missile Count: "+missileCount+"]" + "\n\t" + this.getMissileLauncher().toString();
	}
}
