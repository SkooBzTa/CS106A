/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

	public class MidpointFindingKarel extends SuperKarel {

		public void run () { //Main run method
			layOuters ();
			while (frontIsClear ()) {
				moveToBeeper ();
				moveBeeperIn ();
			}
		}	
		
		private void layOuters () { //Places a Beeper one corner in from the West and East Walls
			if (frontIsClear ()) {
				move ();
				layBeeper ();
			}
			while (frontIsClear ()) {
				move ();
			}
			turnAround ();
			move ();
			layBeeper ();
		}
		
		private void moveToBeeper () { // Moves Karel to the distant beeper
			move ();
			while (noBeepersPresent ()) {
				if (frontIsClear ()) {
					move ();
				}
			}
		}
		
		private void moveBeeperIn () { // Collects the beeper, and places another one corner closer to the centre.
			pickBeeper ();
			turnAround ();
			move ();
			layBeeper ();
		}
		
		private void layBeeper () { // Checks to ensure that there are no beepers before laying a beeper.
			if (noBeepersPresent ()) {
				putBeeper ();
			}
		}


}
