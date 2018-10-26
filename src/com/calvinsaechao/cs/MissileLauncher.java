package com.calvinsaechao.cs;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class MissileLauncher extends MovableObject{
	
	public MissileLauncher(Point2D loc) {
		super.setColor(ColorUtil.WHITE);
		super.setLoc(loc);
	}
	/**
	 * Rotates the MISSILELAUNCHER counter-clockwise
	 */
	public void rotateMissileLauncher() {
		int direction = super.getDirection();
		if(direction == 0)
			super.setDirection(324);
		else
			super.setDirection(direction-36);
	}
	public String toString() {
		return "[Missile        |Location: "+super.getLoc()+"|Color: "+super.getColor()+"|Speed: "+super.getSpeed()+"|Direction "+super.getDirection()+"]";
	}
}
