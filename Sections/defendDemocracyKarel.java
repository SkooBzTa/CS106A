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
		
	private void checkVote(){
		if (noBeepersPresent () && frontIsClear()) {
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
	
	private void moveNext () {
		move ();
			if (frontIsClear()) {
				move ();
			}
	}

}