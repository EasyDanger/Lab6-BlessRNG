package lab6;

public class DiceRollerApp {

	public static void main(String[] args) {
		// Since this program is never meant to run, we don't need to call anything or
		// do anything in this main method.
	}
	// I find that when passing arguments to a method, I like to use the same
	// variable names as are being passed to it to help me personally to keep track,
	// even if they aren't the same variables strictly speaking. So, even just
	// looking at these, i can tell that these values are the dice rolls from the
	// other class.
	public static String logic(int dieHard, int dieHarder) {
		// A side effect of only calling this method for 6 sided die is that there is
		// only one combination that can equal 12 and one that can equal 2, making these
		// conditions slightly simpler.
		if ((dieHard + dieHarder) == 12) {
			return Lab6RandomNumberGod.boxCars();
		} else if ((dieHard + dieHarder) == 2) {
			return Lab6RandomNumberGod.snakeEyes();
		} else if ((dieHard + dieHarder) == 7) {
			return Lab6RandomNumberGod.craps();
		} else {
			return " ";
		}
		// These conditions will return the value going to result in the other class, to
		// be added to the end of the results printout.
	}
}
