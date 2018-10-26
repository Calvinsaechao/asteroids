package com.calvinsaechao.cs;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer{
	private Label score, lives, gameTime, sound; 
	public ScoreView() {
		this.setLayout(new FlowLayout(Component.CENTER));
		this.add(new Label("Score: "));
		score = new Label(" ");
		this.add(score);
		this.add(new Label("Lives: "));
		lives = new Label(" ");
		this.add(lives);
		this.add(new Label("Time: "));
		gameTime = new Label(" ");
		this.add(gameTime);
		this.add(new Label("Sound: "));
		sound = new Label(" ");
		this.add(sound);
	}
	
	public void update(Observable o, Object arg) {
		GameWorldProxy gw = new GameWorldProxy((GameWorld)o);
		score.setText("" + gw.getScore());
		lives.setText("" + gw.getLives());
		gameTime.setText("" + gw.getGameTime());
		if(gw.getSound()) 
			sound.setText("ON");
		else sound.setText("OFF");
		this.repaint();
	}

}
