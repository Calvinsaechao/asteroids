package com.calvinsaechao.cs;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NewCommand extends Command{
	GameWorld gw;
	public NewCommand(GameWorld gw) {
		super("New");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.reset();
		System.out.println("Resetting game...");
	}
}