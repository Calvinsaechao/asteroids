package com.calvinsaechao.cs;
import com.calvinsaechao.cs.commands.AboutCommand;
import com.calvinsaechao.cs.commands.AddAsteroidCommand;
import com.calvinsaechao.cs.commands.AddNonPlayerShipCommand;
import com.calvinsaechao.cs.commands.AddPlayerShipCommand;
import com.calvinsaechao.cs.commands.AddSpaceStationCommand;
import com.calvinsaechao.cs.commands.CollideAACommand;
import com.calvinsaechao.cs.commands.CollideANPSCommand;
import com.calvinsaechao.cs.commands.CollideAPSCommand;
import com.calvinsaechao.cs.commands.CollideMPSCommand;
import com.calvinsaechao.cs.commands.CollideNPSPSCommand;
import com.calvinsaechao.cs.commands.DecreaseSpeedCommand;
import com.calvinsaechao.cs.commands.DestroyAsteroidCommand;
import com.calvinsaechao.cs.commands.DestroyNonPlayerShipCommand;
import com.calvinsaechao.cs.commands.FireMissileCommand;
import com.calvinsaechao.cs.commands.HyperSpaceCommand;
import com.calvinsaechao.cs.commands.IncreaseSpeedCommand;
import com.calvinsaechao.cs.commands.NPSFireMissileCommand;
import com.calvinsaechao.cs.commands.PrintMapCommand;
import com.calvinsaechao.cs.commands.PrintScoreCommand;
import com.calvinsaechao.cs.commands.QuitCommand;
import com.calvinsaechao.cs.commands.ReloadCommand;
import com.calvinsaechao.cs.commands.RotateMissileLauncherCommand;
import com.calvinsaechao.cs.commands.SoundCommand;
import com.calvinsaechao.cs.commands.TickCommand;
import com.calvinsaechao.cs.commands.TurnLeftCommand;
import com.calvinsaechao.cs.commands.TurnRightCommand;
import com.calvinsaechao.cs.commands.UndoCommand;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.commands.*;

public class Game extends Form{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private MyButton addAsteroid, addNPS, addSS, addPS, increaseSpeed, decreaseSpeed, turnLeft, turnRight, fireMissile, nPSFireMissile, rotateMissileLauncher, hyperSpace, reload, destroyAsteroid, destroyNPS, collideMPS, collideAPS, collideNPSPS, collideAA, collideANPS, tick, printScore, printMap, quit;
	private Container westButtons;
	private Command undoCommand, newCommand, aboutCommand, saveCommand, addAsteroidCommand, fireMissileCommand, addNonPlayerShipCommand, addPlayerShipCommand, collideAACommand, collideANPSCommand, collideAPSCommand, collideMPSCommand, collideNPSPSCommand, decreaseSpeedCommand, destroyAsteroidCommand, destroyNonPlayerShipCommand, hyperSpaceCommand, increaseSpeedCommand, nPSFireMissileCommand, printMapCommand, printScoreCommand, quitCommand, reloadCommand, rotateMissileLauncherCommand, tickCommand, turnLeftCommand, turnRightCommand, soundCommand, addSpaceStationCommand;
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView();
		mv = new MapView();
		gw.init();
		this.setTitle("SpaceShip");
		this.setLayout(new BorderLayout());
		
		this.add(BorderLayout.NORTH, sv); //add a score view
		this.add(BorderLayout.CENTER, mv); // add a map view
		gw.addObserver(sv);
		gw.addObserver(mv);
		
		//west buttons
		westButtons = new Container();
		westButtons.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		westButtons.getStyle().setBorder(Border.createLineBorder(1, ColorUtil.BLUE));
		
		//Add 'a' new asteroid button
		addAsteroid = new MyButton("Add Asteroid");
		addAsteroidCommand = new AddAsteroidCommand(gw);
		addAsteroid.setCommand(addAsteroidCommand);
		//this.addKeyListener('a', addAsteroidCommand);
		westButtons.addComponent(addAsteroid);
		
		//'y' add new nonplayership
		addNPS = new MyButton("Add NonPlayerShip");
		addNonPlayerShipCommand = new AddNonPlayerShipCommand(gw);
		addNPS.setCommand(addNonPlayerShipCommand);
		this.addKeyListener('y', addNonPlayerShipCommand);
		westButtons.add(addNPS);
		
		//'b' add new space station
		addSS = new MyButton("Add Spacestation");
		addSpaceStationCommand = new AddSpaceStationCommand(gw);
		addSS.setCommand(addSpaceStationCommand);
		this.addKeyListener('b', addSpaceStationCommand);
		westButtons.add(addSS);
		
		//'s' add new playership
		addPS = new MyButton("Add PlayerShip");
		addPlayerShipCommand = new AddPlayerShipCommand(gw);
		addPS.setCommand(addPlayerShipCommand);
		this.addKeyListener('s', addPlayerShipCommand);
		westButtons.add(addPS);
		
		//'i' increase speed of playership
		increaseSpeed = new MyButton("Increase speed");
		increaseSpeedCommand = new IncreaseSpeedCommand(gw);
		increaseSpeed.setCommand(increaseSpeedCommand);
		this.addKeyListener(-91, increaseSpeedCommand);
		westButtons.add(increaseSpeed);
		
		//'d' decrease speed of playership
		decreaseSpeed = new MyButton("Decrease speed");
		decreaseSpeedCommand = new DecreaseSpeedCommand(gw);
		decreaseSpeed.setCommand(decreaseSpeedCommand);
		this.addKeyListener(-92, decreaseSpeedCommand);
		westButtons.add(decreaseSpeed);
		
		//'l' turn left
		turnLeft = new MyButton("Turn Left");
		turnLeftCommand = new TurnLeftCommand(gw);
		turnLeft.setCommand(turnLeftCommand);
		this.addKeyListener(-93, turnLeftCommand);
		westButtons.add(turnLeft);
		
		//'r' turn right
		turnRight = new MyButton("Turn Right");
		turnRightCommand = new TurnRightCommand(gw);
		turnRight.setCommand(turnRightCommand);
		this.addKeyListener(-94, turnRightCommand);
		westButtons.add(turnRight);
		
		//'<' rotate missile launcher
		rotateMissileLauncher = new MyButton("Rotate missile launcher");
		rotateMissileLauncherCommand = new RotateMissileLauncherCommand(gw);
		rotateMissileLauncher.setCommand(rotateMissileLauncherCommand);
		this.addKeyListener('<', rotateMissileLauncherCommand);
		westButtons.add(rotateMissileLauncher);
		
		//'f' playership fires missile
		fireMissile = new MyButton("Fire Missile");
		fireMissileCommand = new FireMissileCommand(gw);
		fireMissile.setCommand(fireMissileCommand);
		this.addKeyListener('f', fireMissileCommand);
		this.addKeyListener(-90, fireMissileCommand);
		westButtons.add(fireMissile);
		
		//'L' nonplayership fires missile
		nPSFireMissile = new MyButton("NonPlayerShip fires missile");
		nPSFireMissileCommand = new NPSFireMissileCommand(gw);
		nPSFireMissile.setCommand(nPSFireMissileCommand);
		this.addKeyListener('L', nPSFireMissileCommand);
		westButtons.add(nPSFireMissile);
		
		//'j' jump into hyperspace J
		hyperSpace = new MyButton("Jump into hyperspace");
		hyperSpaceCommand = new HyperSpaceCommand(gw);
		hyperSpace.setCommand(hyperSpaceCommand);
		this.addKeyListener('j', hyperSpaceCommand);
		westButtons.add(hyperSpace);
		
		//'n' reload
		reload = new MyButton("Reload");
		reloadCommand = new ReloadCommand(gw);
		reload.setCommand(reloadCommand);
		this.addKeyListener('n', reloadCommand);
		westButtons.add(reload);
		
		//'k' destroy asteroid
		destroyAsteroid = new MyButton("Destroy Asteroid");
		destroyAsteroidCommand = new DestroyAsteroidCommand(gw);
		destroyAsteroid.setCommand(destroyAsteroidCommand);
		this.addKeyListener('k', destroyAsteroidCommand);
		westButtons.add(destroyAsteroid);
		
		//'e' destroy nonplayership
		destroyNPS = new MyButton("Destroy NonPlayerShip");
		destroyNonPlayerShipCommand = new DestroyNonPlayerShipCommand(gw);
		destroyNPS.setCommand(destroyNonPlayerShipCommand);
		this.addKeyListener('e', destroyNonPlayerShipCommand);
		westButtons.add(destroyNPS);
		
		//'E' playership destroy meteor
		collideMPS = new MyButton("PlayerShip collides with Missile");
		collideMPSCommand = new CollideMPSCommand(gw);
		collideMPS.setCommand(collideMPSCommand);
		this.addKeyListener('E', collideMPSCommand);
		westButtons.add(collideMPS);
		
		//'c' playership destroy asteroid
		collideAPS = new MyButton("PlayerShip collides with Asteroid");
		collideAPSCommand = new CollideAPSCommand(gw);
		collideAPS.setCommand(collideAPSCommand);
		this.addKeyListener('c', collideAPSCommand);
		westButtons.add(collideAPS);
		
		//'h' nonplayership collides with playership
		collideNPSPS = new MyButton("NonPlayerShip collides with PlayerShip");
		collideNPSPSCommand = new CollideNPSPSCommand(gw);
		collideNPSPS.setCommand(collideNPSPSCommand);
		this.addKeyListener('h', collideNPSPSCommand);
		westButtons.add(collideNPSPS);
		
		//'x' asteroids collide
		collideAA = new MyButton("Asteroid collides with Asteroid");
		collideAACommand = new CollideAACommand(gw);
		collideAA.setCommand(collideAACommand);
		this.addKeyListener('x', collideAACommand);
		westButtons.add(collideAA);
		
		
		//'I' asteroid and nonplayership collide
		collideANPS = new MyButton("Asteroid collides with NonPlayerShip");
		collideANPSCommand = new CollideANPSCommand(gw);
		collideANPS.setCommand(collideANPSCommand);
		this.addKeyListener('I', collideANPSCommand);
		westButtons.add(collideANPS);
		
		//'t' tick the time
		tick = new MyButton("Tick");
		tickCommand = new TickCommand(gw);
		tick.setCommand(tickCommand);
		this.addKeyListener('t', tickCommand);
		westButtons.add(tick);
		
		//'p' print score
		printScore = new MyButton("Print Score");
		printScoreCommand = new PrintScoreCommand(gw);
		printScore.setCommand(printScoreCommand);
		this.addKeyListener('p', printScoreCommand);
		westButtons.add(printScore);
		
		//'m' print map
		printMap = new MyButton("Print Map");
		printMapCommand = new PrintMapCommand(gw);
		printMap.setCommand(printMapCommand);
		this.addKeyListener('m', printMapCommand);
		westButtons.add(printMap);
		
		//'q' quit game
		quit = new MyButton("Quit");
		quitCommand = new QuitCommand(gw);
		quit.setCommand(quitCommand);
		this.addKeyListener('q', quitCommand);
		westButtons.add(quit);
		
		this.add(BorderLayout.WEST, westButtons);
		this.show();
		
		//settings

		//toolbars
		Toolbar sideMenu = new Toolbar();
		this.setToolbar(sideMenu);
		sideMenu.setTitle("Spaceship");
		soundCommand = new SoundCommand(gw);
		CheckBox soundCheckBox = new CheckBox("Sound");
		soundCheckBox.setSelected(true);
		soundCheckBox.setCommand(soundCommand);
		soundCommand.putClientProperty("SideComponent", soundCheckBox);
		aboutCommand = new AboutCommand();
		undoCommand = new UndoCommand();
		saveCommand = new SaveCommand();
		newCommand = new NewCommand(gw);
		sideMenu.addCommandToSideMenu(addAsteroidCommand);
		sideMenu.addCommandToSideMenu(addSpaceStationCommand);
		sideMenu.addCommandToSideMenu(addPlayerShipCommand);
		sideMenu.addCommandToSideMenu(reloadCommand);
		sideMenu.addCommandToSideMenu(destroyAsteroidCommand);
		sideMenu.addCommandToSideMenu(collideAPSCommand);
		sideMenu.addCommandToSideMenu(collideAACommand);
		sideMenu.addCommandToSideMenu(tickCommand);
		sideMenu.addCommandToSideMenu(quitCommand);
		sideMenu.addComponentToSideMenu(soundCheckBox);
		sideMenu.addCommandToOverflowMenu(newCommand);
		sideMenu.addCommandToOverflowMenu(saveCommand);
		sideMenu.addCommandToOverflowMenu(undoCommand);
		sideMenu.addCommandToOverflowMenu(soundCommand);
		sideMenu.addCommandToOverflowMenu(aboutCommand);
		sideMenu.addCommandToOverflowMenu(quitCommand);
		
		GameWorld.setHeight(mv.getHeight());
		GameWorld.setWidth(mv.getWidth());
		gw.notifyObservers();
	}
}
