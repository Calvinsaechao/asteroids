package com.calvinsaechao.cs;
import java.util.ArrayList;

import com.codename1.ui.geom.Point2D;

public class GameWorld{
	SpaceCollection collection;
	public GameWorld() {
		collection = new SpaceCollection();
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
	}
	/**
	 * Add a NONPLAYERSHIP into the GAMEWORLD
	 */
	public void addNewNPS() {
		collection.add(new NonPlayerShip());
		System.out.println("A new NONPLAYERSHIP has appeared.");
	}
	/**
	 * Add a SPACESTATION into the GAMEWORLD
	 */
	public void addNewSS() {
		collection.add(new Spacestation());
		System.out.println("A new SPACESTATION has appeared.");
	}
	/**
	 * Add a PLAYERSHIP into the GAMEWORLD
	 */
	public void addNewPS() {
		if(PShip.exists())
			System.out.println("A PLAYERSHIP already exsits");
		else {
			PShip.getPS();
			System.out.println("A PLAYERSHIP has appeared");
		}
	}
	/**
	 * Increase the speed of the PLAYERSHIP
	 */
	public void increaseSpeedPS() {
		if(PShip.exists() && PShip.getPS().getSpeed() < 10) {
			PShip.getPS().setSpeed(PShip.getPS().getSpeed()+1);
			System.out.println("Increasing PLAYERSHIP speed");
		}
		else {
			System.out.println("A PLAYERSHIP does not exist");
		}
	}
	/**
	 * Decrease the speed of the PLAYERSHIP
	 */
	public void decreaseSpeedPS() {
		if(PShip.exists() && PShip.getPS().getSpeed() > 0) {
			PShip.getPS().setSpeed(PShip.getPS().getSpeed()-1);
			System.out.println("Decreasing PLAYERSHIP speed");
		}
		else {
			System.out.println("A PLAYERSHIP does not exist");
		}
	}
	/**
	 * Turns the PLAYERSHIP to the left
	 */
	public void turnLeft() {
		PShip.getPS().turnLeft();
		System.out.println("PLAYERSHIP rotated 1 degrees counter-clockwise");
	}
	/**
	 * Turns the PLAYERSHIP to the right
	 */
	public void turnRight() {
		PShip.getPS().turnRight();
		System.out.println("PLAYERSHIP rotated 1 degrees clockwise");
	}
	/**
	 * Rotates PLAYERSHIP's MISSILELAUNCHER counter-clockwise
	 */
	public void rotateMissieleLauncher() {
		PShip.getPS().getMissileLauncher().rotateMissileLauncher();
		System.out.println("MISSILELAUNCHER rotated 36 degrees counter-clockwise");
	}
	/**
	 * PLAYERSHIP fires a MISSILE
	 */
	public void PSFireMissile() {
		PlayerShip pS = PShip.getPS();
		if(pS.fireMissile()) {
			MissileLauncher mL = pS.getMissileLauncher();
			Missile m = new Missile(pS.getSpeed(), mL.getLoc(),mL.getDirection());
			collection.add(m);
			System.out.println("PLAYERSHIP has launched a missile");
		}
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
		if(nPS != null && nPS.fireMissile()) {
			MissileLauncher mL = nPS.getMissileLauncher();
			Missile m = new Missile(nPS.getSpeed(), mL.getLoc(),mL.getDirection());
			collection.add(m);
			System.out.println("A NONPLAYERSHIP has launched a missile");
		}
	}
	/**
	 * PLAYERSHIP jumps into hyperspace appearing in the center of the map
	 */
	public void Hyperspace() {
		PShip.getPS().setLoc(new Point2D(512, 384));
		System.out.println("PLAYERSHIP has jumped into hyperspace, appearing\n\tin the center of the map!");
	}
	/**
	 * PLAYERSHIP reloads
	 */
	public void reload() {
		PShip.getPS().reloadMissiles();
		System.out.println("PLAYERSHIP missiles reloaded");
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
		Missile missile = null;
		if(PShip.exists()) {
			IIterator store = collection.getIterator();
			while(store.hasNext()) {
				GameObject o = (GameObject)store.getNext();
				if(o instanceof Missile) {
					missile = (Missile)o;
				}
			}//while iterator
			if (missile != null) {
				PShip.destroy();
				collection.remove(missile);
				System.out.println("MISSILE collided with PLAYERSHIP");
			}
			else if(missile == null) {
				System.out.println("No MISSILE detected");
			}
		}//if PLAYERSHIP exists
	}
	/**
	 * ASTEROID collides with PLAYERSHIP
	 */
	public void destroyPSA() {
		Asteroid asteroid = null;
		if(PShip.exists()) {
			IIterator store = collection.getIterator();
			while(store.hasNext()) {
				GameObject o = (GameObject)store.getNext();
				if(o instanceof Asteroid) {
					asteroid = (Asteroid)o;
				}
			}//while iterator
			if (asteroid != null) {
				PShip.destroy();
				collection.remove(asteroid);
				System.out.println("ASTEROID collided with PLAYERSHIP");
			}
			else if(asteroid == null) {
				System.out.println("No ASTEROID detected");
			}
		}//if PLAYERSHIP exists
	}
	/**
	 * NONPLAYERSHIP collides with PLAYERSHIP
	 */
	public void destroyPSNPS() {
		NonPlayerShip nps = null;
		if(PShip.exists()) {
			IIterator store = collection.getIterator();
			while(store.hasNext()) {
				GameObject o = (GameObject)store.getNext();
				if(o instanceof NonPlayerShip) {
					nps = (NonPlayerShip)o;
				}
			}//while iterator
			if (nps != null) {
				PShip.destroy();
				collection.remove(nps);
				System.out.println("NONPLAYERSHIP collided with PLAYERSHIP");
			}
			else if(nps == null) {
				System.out.println("No NONPLAYERSHIP detected");
			}
		}//if PLAYERSHIP exists
	}
	/**
	 * Update GAMEOBJECTS in the GAMEWORLD by one increment of time
	 */
	public void tick() {
		if (PShip.exists()) {
			PShip.getPS().move();
		}
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
	}
	/**
	 * Displays a map of the GAMEWORLD
	 */
	public void printMap() {
		System.out.println(PShip.getPS());
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
		}
		else if(asteroid == null) {
			System.out.println("No ASTEROID detected");
		}
		else if(nps == null) {
			System.out.println("No NONPLAYERSHIP detected");
		}
	}
}
