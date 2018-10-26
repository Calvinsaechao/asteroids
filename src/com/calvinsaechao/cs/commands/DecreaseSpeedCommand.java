package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DecreaseSpeedCommand extends Command{
	private GameWorld gw;
	public DecreaseSpeedCommand(GameWorld gw) {
		super("Decrease speed");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeedPS();
	}
}