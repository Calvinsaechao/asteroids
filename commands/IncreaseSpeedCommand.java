package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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