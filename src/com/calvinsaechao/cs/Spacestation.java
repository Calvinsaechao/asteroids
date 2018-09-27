package com.calvinsaechao.cs;

public class Spacestation extends FixedObject {
	private int blinkRate;
	private boolean state;
	public Spacestation() {
		this.blinkRate = Rand.getRandom().nextInt(4)+1;
		state = true;
	}
	/**
	 * Change the state of the SPACESTATION and generate a new blinkRate
	 */
	public void blink() {
		if(blinkRate ==1) {
			System.out.println("SPACESTATION has blinked");
			state = !state;
			blinkRate = Rand.getRandom().nextInt(4)+1;
		}
		else
			blinkRate--;
	}
	public String toString() {
		return "[Spacestation   |Color: "+super.getColor()+"|ID: "+super.getId()+"|Blink Rate: "+blinkRate+"|State: "+state+"]";
	}
}
