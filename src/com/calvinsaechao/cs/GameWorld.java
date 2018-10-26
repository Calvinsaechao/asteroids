package com.calvinsaechao.cs;
import java.util.ArrayList;
import java.util.Observable;

import com.codename1.ui.geom.Point2D;

public class GameWorld extends Observable implements IGameWorld{
	private SpaceCollection collection;
	private int lives;
	private int score;
	private int gameTime;
	private static int width;
	private static int height;
	private boolean sound;
	public GameWorld() {
		collection = new SpaceCollection();
		lives = 5;
		score = 0;
		gameTime = 0;
		width = 0;
		height = 0;
		sound = false;
	}
	public void init() {
		//code here to create the initial game objects/setup
	}
		//additional methods here to manipulate world objects and related game state data
	/**
	 * Removes a NONPLAYERSHIP
	 */
	public void eliminateNPS() {
		boolean destroyed = false;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof NonPlayerShip) {
				collection.remove(o);        //NPS destroyed
				System.out.println("A NONPLAYERSHIP has been destroyed");
				setChanged();
				notifyObservers();
				destroyed = true;
				break;
			}//if NPS
		}//while iterator
		if (!destroyed) System.out.println("A NONPLAYERSHIP does not exist");
	}//end
	/**
	 * Removes a ASTEROID
	 */
	public void eliminateAsteroid() {
		boolean destroyed = false;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof Asteroid) {
				collection.remove(o);        //asteroid destroyed
				System.out.println("A Asteroid has been destroyed");
				setChanged();
				notifyObservers();
				destroyed = true;
				break;
			}//if NPS
		}//while iterator
		if (!destroyed) System.out.println("A Asteroid does not exist");
	}//end
	/**
	 * Add a ASTEROID into the GAMEWORLD
	 */
	public void addNewAsteroid() {
		collection.add(new Asteroid());
		System.out.println("A new ASTEROID has appeared.");
		setChanged();
		notifyObservers();
	}
	/**
	 * Add a NONPLAYERSHIP into the GAMEWORLD
	 */
	public void addNewNPS() {
		collection.add(new NonPlayerShip());
		System.out.println("A new NONPLAYERSHIP has appeared.");
		setChanged();
		notifyObservers();
	}
	/**
	 * Add a SPACESTATION into the GAMEWORLD
	 */
	public void addNewSS() {
		collection.add(new Spacestation());
		System.out.println("A new SPACESTATION has appeared.");
		setChanged();
		notifyObservers();
	}
	/**
	 * Add a PLAYERSHIP into the GAMEWORLD
	 */
	public void addNewPS() {
		boolean pSExists = false;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
				pSExists = true;
				break;
			}//if PS
		}//while iterator
		if (!pSExists) {
			collection.add(new PlayerShip());
			System.out.println("A new PLAYERSHIP has appeared.");
			setChanged();
			notifyObservers();
		}
		else {
			System.out.println("A PLAYERSHIP already exists");
		}
	}
	/*public void addNewPS() {
		if(PShip.exists())
			System.out.println("A PLAYERSHIP already exsits");
		else {
			PShip.getPS();
			System.out.println("A PLAYERSHIP has appeared");
		}
	}
	*/
	/**
	 * Increase the speed of the PLAYERSHIP
	 */
	public void increaseSpeedPS() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof ISteerable) {
				if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				}
				break;
			}//if PS
		}//while iterator
		if(exists && pS.getSpeed() < 10) {
			pS.setSpeed(pS.getSpeed()+1);
			System.out.println("Increasing PLAYERSHIP speed");
			setChanged();
			notifyObservers();
		}
		else if(exists && pS.getSpeed() == 10){
			System.out.println("PLAYERSHIP is at max speed");
		}
		else {
			System.out.println("A PLAYERSHIP does not exist");
		}
	}
	/**
	 * Decrease the speed of the PLAYERSHIP
	 */
	public void decreaseSpeedPS() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof ISteerable) {
				if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				}
				break;
			}//if PS
		}//while iterator
		if(exists && pS.getSpeed() > 0) {
			pS.setSpeed(pS.getSpeed()-1);
			System.out.println("Decreasing PLAYERSHIP speed");
			setChanged();
			notifyObservers();
		}
		else if(exists && pS.getSpeed() == 0) {
			System.out.println("PLAYERSHIP is at minimum speed");
		}
		else {
			System.out.println("A PLAYERSHIP does not exist");
		}
	}
	/**
	 * Turns the PLAYERSHIP to the left
	 */
	public void turnLeft() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof ISteerable) {
				if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				}
				break;
			}//if PS
		}//while iterator
		if(exists) {
			pS.turnLeft();
			System.out.println("PLAYERSHIP rotated 1 degrees counter-clockwise");
			setChanged();
			notifyObservers();
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * Turns the PLAYERSHIP to the right
	 */
	public void turnRight() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof ISteerable) {
				if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				}
				break;
			}//if PS
		}//while iterator
		if(exists) {
			pS.turnRight();
			System.out.println("PLAYERSHIP rotated 1 degrees clockwise");
			setChanged();
			notifyObservers();
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * Rotates PLAYERSHIP's MISSILELAUNCHER counter-clockwise
	 */
	public void rotateMissieleLauncher() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				break;
			}//if PS
		}//while iterator
		if(exists) {
			pS.getMissileLauncher().rotateMissileLauncher();
			System.out.println("MISSILELAUNCHER rotated 36 degrees counter-clockwise");
			setChanged();
			notifyObservers();
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * PLAYERSHIP fires a MISSILE
	 */
	public void PSFireMissile() {
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					pS = (PlayerShip) o;
				break;
			}//if PS
		}//while iterator
		if(pS != null) {
			if(pS.fireMissile()) {
				MissileLauncher mL = pS.getMissileLauncher();
				Missile m = new Missile(pS.getSpeed(), mL.getLoc(),mL.getDirection());
				collection.add(m);
				System.out.println("PLAYERSHIP has launched a missile");
				setChanged();
				notifyObservers();
			}
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * NONPLAYERSHIP fires a MISSILE
	 */
	public void NPSFireMissile() {
		NonPlayerShip nPS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof NonPlayerShip) {
					nPS = (NonPlayerShip) o;
				break;
			}//if NPS
		}//while iterator
		if(nPS != null) {
			if(nPS.fireMissile()) {
				MissileLauncher mL = nPS.getMissileLauncher();
				Missile m = new Missile(nPS.getSpeed(), mL.getLoc(),mL.getDirection());
				collection.add(m);
				System.out.println("A NONPLAYERSHIP has launched a missile");
				setChanged();
				notifyObservers();
			}
		}
		else {
			System.out.println("A NONPLAYERSHIP does not exist");
		}
	}
	/**
	 * PLAYERSHIP jumps into hyperspace appearing in the center of the map
	 */
	public void Hyperspace() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				break;
			}//if PS
		}//while iterator
		if (exists) {
			pS.setLoc(new Point2D(512, 384));
			System.out.println("PLAYERSHIP has jumped into hyperspace, appearing\n\tin the center of the map!");
			setChanged();
			notifyObservers();
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * PLAYERSHIP reloads
	 */
	public void reload() {
		boolean exists = false;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
				break;
			}//if PS
		}//while iterator
		if(exists) {
			pS.reloadMissiles();
			System.out.println("PLAYERSHIP missiles reloaded");
			setChanged();
			notifyObservers();
		}
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * MISSILE collides with ASTEROID
	 */
	public void destroyAsteroid() {
		Missile missile = null;
		Asteroid asteroid = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof Asteroid) {
				asteroid = (Asteroid)o;
			}//if NPS
			if(o instanceof Missile) {
				missile = (Missile)o;
			}
		}//while iterator
		if (missile != null && asteroid != null) {
			collection.remove(asteroid);
			collection.remove(missile);
			System.out.println("MISSILE collided with ASTEROID");
			score += 150;
			setChanged();
			notifyObservers();
		}
		else if(missile == null) {
			System.out.println("No MISSILE detected");
		}
		else if(asteroid == null) {
			System.out.println("No ASTEROID detected");
		}
	}
	/**
	 * MISSILE collides with NONPLAYERSHIP
	 */
	public void destroyNPS() {
		Missile missile = null;
		NonPlayerShip nps = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof NonPlayerShip) {
				nps = (NonPlayerShip)o;
			}//if NPS
			if(o instanceof Missile) {
				missile = (Missile)o;
			}
		}//while iterator
		if (missile != null && nps != null) {
			collection.remove(nps);
			collection.remove(missile);
			System.out.println("MISSILE collided with NONPLAYERSHIP");
			score += 500;
			setChanged();
			notifyObservers();
		}
		else if(missile == null) {
			System.out.println("No MISSILE detected");
		}
		else if(nps == null) {
			System.out.println("No NONPLAYERSHIP detected");
		}
	}
	/**
	 * MISSILE collides with PLAYERSHIP
	 */
	public void destroyPSM() {
		boolean exists = false;
		PlayerShip pS = null;
		Missile missile = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					exists = true;
					pS = (PlayerShip) o;
			}//if PS
			else if (o instanceof Missile) {
				missile = (Missile)o;
			}
		}//while iterator
		if(exists) {
			if (missile != null) {
				collection.remove(pS); //destroy PLAYERSHIP
				collection.remove(missile);
				System.out.println("MISSILE collided with PLAYERSHIP");
				lives--;
				setChanged();
				notifyObservers();
			}
			else if(missile == null) {
				System.out.println("No MISSILE detected");
			}
		}//if PLAYERSHIP exists
		else System.out.println("A PLAYERSHIP does not exist");
	}
	/**
	 * ASTEROID collides with PLAYERSHIP
	 */
	public void destroyPSA() {
		Asteroid asteroid = null;
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof Asteroid) {
				asteroid = (Asteroid)o;
			}
			else if (o instanceof PlayerShip) {
				pS = (PlayerShip)o;
			}
		}//while iterator
		if (asteroid != null && pS != null) {
			collection.remove(pS);
			collection.remove(asteroid);
			System.out.println("ASTEROID collided with PLAYERSHIP");
			lives--;
			setChanged();
			notifyObservers();
		}
		else if(asteroid == null) {
			System.out.println("No ASTEROID detected");
		}
		else if(pS == null) {
			System.out.println("A PLAYERSHIP does not exist");
		}
	}
	/**
	 * NONPLAYERSHIP collides with PLAYERSHIP
	 */
	public void destroyPSNPS() {
		PlayerShip pS = null;
		NonPlayerShip nps = null;
			IIterator store = collection.getIterator();
			while(store.hasNext()) {
				GameObject o = (GameObject)store.getNext();
				if(o instanceof NonPlayerShip) {
					nps = (NonPlayerShip)o;
				}
				else if (o instanceof PlayerShip) {
					pS = (PlayerShip)o;
				}
			}//while iterator
			if (nps != null && pS != null) {
				collection.remove(pS);
				collection.remove(nps);
				System.out.println("NONPLAYERSHIP collided with PLAYERSHIP");
				lives--;
				setChanged();
				notifyObservers();
			}
			else if(nps == null) {
				System.out.println("No NONPLAYERSHIP detected");
			}
			else if(pS == null) {
				System.out.println("A PLAYERSHIP does not exist");
			}
	}
	/**
	 * Update GAMEOBJECTS in the GAMEWORLD by one increment of time
	 */
	public void tick() {
		gameTime++;
		ArrayList<Missile> a = new ArrayList<Missile>();
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof IMovable) {
				((IMovable) o).move();
				if(o instanceof Missile) {
					if(((Missile) o).getFuel() == 0) a.add((Missile)o);
				}
			}//if NPS
			if(o instanceof Spacestation) {
				((Spacestation) o).blink();
			}
		}//while iterator
		while(!a.isEmpty()) collection.remove(a.remove(0));
		setChanged();
		notifyObservers();
	}
	/**
	 * Displays a map of the GAMEWORLD
	 */
	public void printMap() {
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			System.out.println(o);
		}//while iterator
	}
	/**
	 * Two ASTEROIDS collide
	 */
	public void AsteroidCollision() {
		IIterator store = collection.getIterator();
		int tick = 0;
		Asteroid one = null, two = null;
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(tick < 2) {
				if(o instanceof Asteroid) {
					if(tick == 0) {
						one = (Asteroid)o;
						tick++;
					}
					else {
						tick++;
						two = (Asteroid)o;
					}
				}
			}
			else break;
		}//while iterator
		if(tick == 2) {
			collection.remove(one);
			collection.remove(two);
			System.out.println("Asteroids collided");
			setChanged();
			notifyObservers();
		}
		else {
			System.out.println("Asteroid collision failed");
		}
	}
	/**
	 * NONPLAYERSHIP collides with ASTEROID
	 */
	public void AsteroidNPSCollision() {
		Asteroid asteroid = null;
		NonPlayerShip nps = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof NonPlayerShip) {
				nps = (NonPlayerShip)o;
			}//if NPS
			if(o instanceof Asteroid) {
				asteroid = (Asteroid)o;
			}
		}//while iterator
		if (asteroid != null && nps != null) {
			collection.remove(nps);
			collection.remove(asteroid);
			System.out.println("ASTEROID collided with NONPLAYERSHIP");
			setChanged();
			notifyObservers();
		}
		else if(asteroid == null) {
			System.out.println("No ASTEROID detected");
		}
		else if(nps == null) {
			System.out.println("No NONPLAYERSHIP detected");
		}
	}
	public PlayerShip getPlayerShip() {
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
					return ((PlayerShip)o);
			}//if PS
		}//while iterator
		return null;
	}
	/**
	 * Retrieves lives left
	 * @return
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * Retrieves current score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Retrieves current game time
	 * @return
	 */
	public int getGameTime() {
		return gameTime;
	}
	public void printScore() {
		PlayerShip pS = null;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			GameObject o = (GameObject)store.getNext();
			if(o instanceof PlayerShip) {
				pS = (PlayerShip)o;
			}
		}
		if(pS != null) {
			System.out.println("--------------------------------------------------\n"
					 + "----------------------Display---------------------\n"
					 + "--------------------------------------------------\n"
					 + "Score:         " +score+"\n"
					 + "Missiles left: "+pS.getMissileCount()+"\n"
					 + "Time Elapse:   "+gameTime+"\n"
					 + "--------------------------------------------------\n"
					 + "--------------------------------------------------\n"
					 + "--------------------------------------------------");
		}
		else {
			System.out.println("--------------------------------------------------\n"
					 + "----------------------Display---------------------\n"
					 + "--------------------------------------------------\n"
					 + "Score:         " +score+"\n"
					 + "Missiles left: " +"N/A\n"
					 + "Time Elapse:   " +gameTime+"\n"
					 + "--------------------------------------------------\n"
					 + "--------------------------------------------------\n"
					 + "--------------------------------------------------");
		}
	}
	public void notifyObservers() {
		if(hasChanged()) {
			GameWorldProxy gameWorld = new GameWorldProxy(this);
			super.notifyObservers(gameWorld);
		}
		clearChanged();
	}
	public static void setWidth(int w) {
		width = w;
	}
	public static void setHeight(int h) {
		height = h;
	}
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}
	public void setSound(){
		this.sound = !sound;
		setChanged();
		notifyObservers();
	}
	public boolean getSound(){
		return sound;
	}
	public void reset() {
		this.lives = 5;
		this.gameTime = 0;
		this.score = 0;
		IIterator store = collection.getIterator();
		while(store.hasNext()) {
			collection.remove(store.getNext());
		}
		setChanged();
		notifyObservers();
	}
}
