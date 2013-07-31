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
			layBeeper ();
			if (frontIsClear()) {
				layRow ();
			}else {
				faceNorth ();//if world is only 1 avenue wide, sends Karel north.
				layRow ();
			}
			while (frontIsClear ()) {
				nextRow ();
			}
	}

	private void layRow () {
		/*
		 * Tells Karel to lay an entire row of beepers
		 */
		while (frontIsClear ()) {
			move ();
			if (frontIsClear ()) {
				move ();
				layBeeper ();
			}
		}
		faceNorth ();
	}

	private void nextRow () {
		/*
		 * Tells Karel to move into place to start the next street
		 */
		if (noBeepersPresent ()) {
			moveUp();
			layBeeper ();
		} else {
			moveUp();
			move();
			layBeeper();
		}
		layRow() ;
	}

	private void moveUp () { // moves Karel up to the next street, and makes him turn inwards
		if (frontIsClear ()) { 
			move();
			if (rightIsBlocked ()) {
				turnLeft();
			} else {
				turnRight();
			}
		}	
	}

	private void layBeeper () { //checks for the presence of a beeper before putting one down
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
