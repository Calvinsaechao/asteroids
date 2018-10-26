package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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