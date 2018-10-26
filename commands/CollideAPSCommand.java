package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideAPSCommand extends Command{
	private GameWorld gw;
	public CollideAPSCommand(GameWorld gw) {
		super("Asteroid collides with PlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.destroyPSA();
	}
}