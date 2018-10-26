package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnLeftCommand extends Command{
	private GameWorld gw;
	public TurnLeftCommand(GameWorld gw) {
		super("Turn Left");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.turnLeft();
	}
}