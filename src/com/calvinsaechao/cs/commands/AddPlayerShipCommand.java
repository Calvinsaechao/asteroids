package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddPlayerShipCommand extends Command{
	private GameWorld gw;
	public AddPlayerShipCommand(GameWorld gw) {
		super("Add PlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNewPS();
	}
}
