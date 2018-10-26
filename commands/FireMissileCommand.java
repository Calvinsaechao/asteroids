package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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
