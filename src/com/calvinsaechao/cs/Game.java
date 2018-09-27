package com.calvinsaechao.cs;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
public class Game extends Form{
	private GameWorld gw;
	private int life;
	private int score;
	private int gameTime;
	
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		life = 5;
		score = 0;
		gameTime = 0;
		play();
	}
	/**
	 * Handles the commands of the user
	 */
	private void play() {
		//code here to accept user inputs
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				try{
					sCommand.charAt(0);
				}
				catch(Exception e) {
					sCommand = " ";
					System.out.println("Empty command");
				}
				myTextField.clear();
				switch (sCommand.charAt(0)) {
				case 'a':
					gw.addNewAsteroid();
					break;
				case 'y':
					gw.addNewNPS();
					break;
				case 'b':
					gw.addNewSS();
					break;
				case 's':
					gw.addNewPS();
					break;
				case 'i':
					gw.increaseSpeedPS();
					break;
				case 'd':
					gw.decreaseSpeedPS();
					break;
				case 'l':
					gw.turnLeft();
					break;
				case 'r':
					gw.turnRight();
					break;
				case '<':
					gw.rotateMissieleLauncher();
					break;
				case 'f':
					gw.PSFireMissile();
					break;
				case 'L':
					gw.NPSFireMissile();
					break;
				case 'j':
					gw.Hyperspace();
					break;
				case 'n':
					gw.reload();
					break;
				case 'k':
					gw.destroyAsteroid();
					score += 150;
					break;
				case 'e':
					gw.destroyNPS();
					score += 500;
					break;
				case 'E':
					gw.destroyPSM();
					removeLife();
					break;
				case 'c':
					gw.destroyPSA();
					removeLife();
					break;
				case 'h':
					gw.destroyPSNPS();
					removeLife();
					break;
				case 'x':
					gw.AsteroidCollision();
					break;
				case 'I':
					gw.AsteroidNPSCollision();
					break;
				case 't':
					tick();
					break;
				case 'p':
					System.out.println("--------------------------------------------------\n"
									 + "----------------------Display---------------------\n"
									 + "--------------------------------------------------\n"
									 + "Score:         " +score+"\n"
									 + "Missiles left: "+PShip.getPS().getMissileCount()+"\n"
									 + "Time Elapse:   "+gameTime+"\n"
									 + "--------------------------------------------------\n"
									 + "--------------------------------------------------\n"
									 + "--------------------------------------------------");
					break;
				case 'm':
					gw.printMap();
					break;
				case 'q':
					System.exit(0);
					break;
					
					//add code to handle rest of the commands
				}//switch
			}//actionPerformed
		}//new ActionListener()
		);//addActionListener
	}//play
	/**
	 * Deducts a life from the player
	 */
	private void removeLife() {
		if (life != 0) life--;
		else {
			System.out.println("You have 0 lives! You lose."
					+ "\nYour score was: " + score
					+ "\nGame restarted...");
			life = 5;
			score = 0;
		}
	}
	/**
	 * Increments the gameTime by one and updates the GameWorld
	 */
	private void tick() {
		gameTime++;
		gw.tick();
	}
}
