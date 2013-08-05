/* Karel is cleaning up the voting ballot. 
 * The vote only counts if the middle rectangle is punched,
 * which means there are no beepers present. 
 */

import stanford.karel.SuperKarel;

public class defendDemocracyKarel extends SuperKarel {

	public void run() {
		move ();
		checkVote ();
		while (frontIsClear()) {
				moveNext ();
				checkVote ();
		}
	}
	
	/*
	* Checks a voting panel. If there is no Beeper present on the centre position, Karel will check the top, and then
	* bottom position for 'chads'. if any beepers are found, Karel will pick them up.
	*/
	
	private void checkVote(){
		if (noBeepersPresent ()) {
			turnLeft();
			move();
			while (beepersPresent ()) {
				pickBeeper ();
			}
			turnAround ();
			move ();
			move ();
			while (beepersPresent ()) {
				pickBeeper ();
			}
			turnAround ();
			move ();
			turnRight ();
		}
	}
	
	/*
	* Moves Karel to the next voting panel.
	*/
	
	private void moveNext () {
		move ();
			if (frontIsClear()) {
				move ();
			}
	}

}
