/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		fixColumn();
		while(frontIsClear()){
			nextColumn();
		}
		
				
	}
	
	private void fixColumn() {
		/*
		 * Repairs a column by ascending and placing beepers(bricks) then descending 
		 */
		ascendColumn();
		descendColumn();
	}
	
	private void ascendColumn() {
		/*
		 * Ascends the column looking for holes along the way,
		 * fills any holes with a beeper (brick)
		 */
		while (notFacingNorth()) {
			turnLeft();
		}
		while (frontIsClear()) {
			checkForHole();
			move();
			}
		checkForHole();
	}
	
	private void descendColumn() {
		/*
		 * Descends the column all the way to the bottom
		 */
		while (notFacingSouth()) {
			turnLeft();
		}
		while (frontIsClear()) {
		move();
		}
		while (notFacingEast()) {
		turnLeft();
		}
	}
	
	private void nextColumn() {
		/*
		 * Moves Karel to where the next column should be (providing he is standing at
		 * the base of a column)
		 */
		for (int i = 0; i < 4; i++){
			if (frontIsClear()) {
				move();
			}
		}
		fixColumn();
	}

	private void checkForHole() {
		/*
		 * Checks where Karel is standing, and if no brick is present, Karel will put one there
		 */
		if(noBeepersPresent())
			putBeeper();
	}

}