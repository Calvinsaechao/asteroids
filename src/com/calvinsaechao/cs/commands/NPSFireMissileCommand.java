package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NPSFireMissileCommand extends Command{
	private GameWorld gw;
	public NPSFireMissileCommand(GameWorld gw) {
		super("NonPlayerShip fires missile");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.NPSFireMissile();
	}
}