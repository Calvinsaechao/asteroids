package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class RotateMissileLauncherCommand extends Command{
	private GameWorld gw;
	public RotateMissileLauncherCommand(GameWorld gw) {
		super("Rotate MissileLauncher");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.rotateMissieleLauncher();
	}
}