package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command{
	private GameWorld gw;
	public AddAsteroidCommand(GameWorld gw) {
		super("Add new Asteroid");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNewAsteroid();
	}
}
