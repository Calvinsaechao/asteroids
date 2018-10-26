package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddSpaceStationCommand extends Command{
	private GameWorld gw;
	public AddSpaceStationCommand(GameWorld gw) {
		super("Add Spacestation");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNewSS();
	}
}
