package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class HyperSpaceCommand extends Command{
	private GameWorld gw;
	public HyperSpaceCommand(GameWorld gw) {
		super("Jump into hyperspace");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.Hyperspace();
	}
}