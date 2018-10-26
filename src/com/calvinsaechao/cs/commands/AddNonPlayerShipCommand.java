package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddNonPlayerShipCommand extends Command{
	private GameWorld gw;
	public AddNonPlayerShipCommand(GameWorld gw) {
		super("Add NonPlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNewNPS();
	}
}