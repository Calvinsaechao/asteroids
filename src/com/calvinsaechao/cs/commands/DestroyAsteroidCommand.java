package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DestroyAsteroidCommand extends Command{
	private GameWorld gw;
	public DestroyAsteroidCommand(GameWorld gw) {
		super("Destroy Asteroid");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.destroyAsteroid();
	}
}
