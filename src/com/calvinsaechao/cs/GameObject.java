package com.calvinsaechao.cs;
import com.codename1.ui.geom.Point2D;

import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	private Point2D loc;
	private int color;
	
	public GameObject() {
		loc = randomLoc();
		color = ColorUtil.rgb(188, 122, 16);
	}
	
	/**
	 * Retrieves the location of the object
	 * @return Point2D
	 */
	public Point2D getLoc() {
		return loc;
	}
	/**
	 * Retrieves the color of the object
	 * @return ColorUtil
	 */
	public int getColor() {
		return color;
	}
	/**
	 * Set the location of the object
	 * @param loc: Point2D
	 */
	public void setLoc(Point2D loc) {
		this.loc = loc;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Generates a random location of X and Y where X is from 0 to 1024 and Y is from 0 to 768
	 * @return Point2D
	 */
	private Point2D randomLoc() {
		return new Point2D(Rand.getRandom().nextInt(1025), Rand.getRandom().nextInt(769));
	}
}
