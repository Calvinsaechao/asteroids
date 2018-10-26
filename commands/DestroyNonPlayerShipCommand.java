package com.mycompany.a2.commands;


import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DestroyNonPlayerShipCommand extends Command{
	private GameWorld gw;
	public DestroyNonPlayerShipCommand(GameWorld gw) {
		super("Destroy NonPlayerShip");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.destroyNPS();
	}
}