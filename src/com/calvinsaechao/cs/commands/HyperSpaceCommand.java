package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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