package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideANPSCommand extends Command{
	private GameWorld gw;
	public CollideANPSCommand(GameWorld gw) {
		super("Asteroid collides with NonPlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.AsteroidNPSCollision();
	}
}