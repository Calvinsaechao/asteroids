package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideAACommand extends Command{
	private GameWorld gw;
	public CollideAACommand(GameWorld gw) {
		super("Asteroid collides with Asteroid");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.AsteroidCollision();
	}
}