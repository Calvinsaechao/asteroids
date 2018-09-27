package com.calvinsaechao.cs;

public class PShip {
	private static PlayerShip pS;
	private PShip() {}
	/**
	 * Initializes and returns the PLAYERSHIP
	 * @return PlayerShip
	 */
	public static PlayerShip getPS() {
		if(pS == null) {
			pS = new PlayerShip();
		}
		return pS;
	}
	/**
	 * Checks if the PLAYERSHIP already exists
	 * @return
	 */
	public static boolean exists() {
		if (pS == null) return false;
		return true;
	}
	/**
	 * Destroy the PLAYERSHIP
	 */
	public static void destroy() {
		pS = null;
	}
}
