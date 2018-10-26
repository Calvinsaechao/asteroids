package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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