package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class IncreaseSpeedCommand extends Command{
	private GameWorld gw;
	public IncreaseSpeedCommand(GameWorld gw) {
		super("Increase speed");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.increaseSpeedPS();
	}
}