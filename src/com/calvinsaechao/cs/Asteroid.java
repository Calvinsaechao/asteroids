package com.calvinsaechao.cs;

public class Asteroid extends MovableObject{
	private int size;
	public String toString() {
		return "[Asteroid       |Location: "+super.getLoc()+"|Color: "+super.getColor()+"|Speed: "+super.getSpeed()+"|Direction "+super.getDirection()+
				"|Size: "+size+"]";
	}
}
