/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

  // Run Program. Tells Karel to lay out beepers in a checkerboard pattern.
	
	public void run () {
			layRow ();
			while (frontIsClear ()) {
				nextRow ();
			}
	}
	
	private void layRow () {
		/*
		 * Tells Karel to lay an entire row of beepers
		 */
		while (frontIsClear ()) {
			layBeeper ();
			moveTwo ();
		}
		faceNorth ();
	}
	
	private void nextRow () {
		/*
		 * Tells Karel to move into place to start the next row (if required)
		 */
		if (noBeepersPresent ()) {
			moveUp();
		} else {
			moveUp();
			move();
		}
		layRow() ;
	}
		
	private void moveUp () {
		if (frontIsClear ()) { 
			move();
			if (rightIsBlocked ()) {
				turnLeft();
			} else {
				turnRight();
			}
		}	
	}
		
	private void moveTwo () {
		for (int i = 0; i < 2; i++) {	
			if (frontIsClear ()) {
				move();
			}
		}	
	}
	
	private void layBeeper () {
		if (noBeepersPresent ()) {
			putBeeper ();
		}
	}
	
	private void faceNorth() {
		/*
		 * Turns Karel to the North if he is not already facing that direction
		 */
		while (notFacingNorth()) {
			turnLeft();
		}
	}

}
