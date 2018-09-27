package com.calvinsaechao.cs;

import java.util.Random;

public class Rand {
	private static Random rand;
	
	private Rand() {
	}
	/**
	 * Initializes and returns a RANDOM
	 * @return Random
	 */
	public static Random getRandom() {
		if(rand == null) {
			rand = new Random();
		}
		return rand;
	}
}
