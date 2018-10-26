package com.calvinsaechao.cs;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SaveCommand extends Command{
	public SaveCommand() {
		super("Save");
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save button");
	}
}
