package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintMapCommand extends Command{
	private GameWorld gw;
	public PrintMapCommand(GameWorld gw) {
		super("Print Map");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.printMap();
	}
}