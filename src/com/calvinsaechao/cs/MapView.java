package com.calvinsaechao.cs;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	public MapView() {
		this.getStyle().setBorder(Border.createLineBorder(2,ColorUtil.BLACK));
	}
	@Override
	public void update(Observable o, Object arg) {
		//GameWorldProxy gw = (GameWorldProxy)o;
		System.out.println("Map updated...");
		
	}

}
