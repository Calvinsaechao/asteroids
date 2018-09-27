package com.calvinsaechao.cs;

public class NonPlayerShip extends MovableObject{
	private int size;
	private int missileCount;
	MissileLauncher missileLauncher;
	public NonPlayerShip() {
		size = 10;
		missileCount = 2;
		missileLauncher = new MissileLauncher(super.getLoc());
	}
	/**
	 * Deduct missile count by one and check if the missile count is zero
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
	 * Retrieves the missile launcher
	 * @return MissileLauncher
	 */
	public MissileLauncher getMissileLauncher() {
		return missileLauncher;
	}
	/**
	 * Moves the missile launcher with the NONPLAYERSHIP
	 */
	public void move() {
		super.move();
		missileLauncher.setLoc(super.getLoc());
	}
	public String toString() {
		return "[NonPlayerShip  Location: "+super.getLoc()+"|Color: "+super.getColor()+"|Speed: "+super.getSpeed()+"|Direction "+super.getDirection()+
				"|Missile Count: "+missileCount+"|Size: "+size+"]";
	}
}
