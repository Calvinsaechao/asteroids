package com.calvinsaechao.cs.commands;


import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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