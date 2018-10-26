package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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