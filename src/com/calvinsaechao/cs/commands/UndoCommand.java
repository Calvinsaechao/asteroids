package com.calvinsaechao.cs.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class UndoCommand extends Command{
	public UndoCommand() {
		super("Undo");
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Undo button");
	}
}
