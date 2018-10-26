package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FireMissileCommand extends Command{
	GameWorld gw;
	public FireMissileCommand(GameWorld gw) {
		super("Fire Missile");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.PSFireMissile();
	}
}
