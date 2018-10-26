package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command{
	private GameWorld gw;
	public TickCommand(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.tick();
	}
}