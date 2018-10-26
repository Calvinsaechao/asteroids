package com.calvinsaechao.cs.commands;

import com.calvinsaechao.cs.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ReloadCommand extends Command{
	private GameWorld gw;
	public ReloadCommand(GameWorld gw) {
		super("Reload");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e) {
		gw.reload();
	}
}