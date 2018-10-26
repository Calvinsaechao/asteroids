package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnRightCommand extends Command{
	private GameWorld gw;
	public TurnRightCommand(GameWorld gw) {
		super("Turn right");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.turnRight();
	}
}