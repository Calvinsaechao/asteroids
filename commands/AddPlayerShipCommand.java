package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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
