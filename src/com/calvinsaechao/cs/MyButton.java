package com.calvinsaechao.cs;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;

public class MyButton extends Button{
	public MyButton(String button) {
		super(button);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setPadding(1, 1, (float)0.5, (float)0.5);
	}
}
