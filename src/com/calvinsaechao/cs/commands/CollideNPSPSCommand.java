package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideNPSPSCommand extends Command{
	private GameWorld gw;
	public CollideNPSPSCommand(GameWorld gw) {
		super("NonPlayerShip collides with PlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.destroyPSNPS();
	}
}