package com.calvinsaechao.cs;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld{
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
		}
	public int getScore() {
		// TODO Auto-generated method stub
		return gw.getScore();
	}
	public int getLives() {
		// TODO Auto-generated method stub
		return gw.getLives();
	}
	public int getGameTime() {
		// TODO Auto-generated method stub
		return gw.getGameTime();
	}
	public boolean getSound() {
		return gw.getSound();
	}

}
