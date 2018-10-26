package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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