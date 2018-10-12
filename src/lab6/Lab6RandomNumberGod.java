package lab6;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lab6RandomNumberGod {
	// Again, variables ended up moved to before the method and made static as they
	// were originally declared before I knew exactly which methods they would be
	// used in. As I finalized the logic and simplified things, I realized that all
	// of these could be declared within the method where they're used, with the
	// exception of, maybe, the Scanner. I may move them in a future version if I
	// return to this, but for now, they'll stay here, not breaking anything.

	// RNGesus is who we pray to in the videogame speedrunning community, the Son of
	// the almighty Random Number God. Here, rNGesus simply names our Random object.
	static Random rNGesus = new Random();
	// result will print the added phrases given for snake eyes, box cars, and craps
	// rolls.
	static String result;
	// count will keep count of now many rolls have been ... rolled.
	static int count;
	// Hey, look! A Scanner object!
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		// We finally started putting our prompts and explanations before the loops!
		// Also implemented user input to slow the program down, so the user could
		// actually read one thing at a time, hence the nextLine() calls.
		System.out.println(
				"Hi. Welcome to the Grand Circus Casino! \n\nWe're totally zoned for this and everything is legal! (Enter to continue)");
		read.nextLine();
		System.out.println("We're going to roll a pair of dice and see what your luck says. (Enter)");
		read.nextLine();
		// So, I wanted the text to read slightly differently in the loop than it does
		// the first time through. Partly because I think it makes the loop read more
		// thoughtfully, and partly because it helps me to distinguish what is looping
		// for my own benefit. (This is also why the text read slightly differently at
		// different parts in the previous lab.) Also, I'm practicing with taking better
		// control of the various print methods. So, here, the first time through, it
		// begins with "First, how many ..." and the subsequent times, it will print
		// "How many times ..." dropping the "First," since it's no longer the first
		// time, natch.
		System.out.print("First, h");
		// Here we call the roll() method, starting the bulk of the program, and
		// allowing us to not have to worry about the preamble text in the loop like we
		// usually do.
		roll();
		// This has been driving me nuts since the pre-work. I spent hours and hours
		// trying to figure out why my code would deliver the ending statements for as
		// many times as the loop was implemented. This is one of the reasons why I've
		// glommed onto do-while loops. I FINALLY figured out that it's because I had
		// sysout text set to print after the method was called again, but within the
		// method. So the system was basically holding on to each instance of that, and
		// after I stopped looping, it was giving me all of them. So, if I looped 6
		// times, I've get "goodbye" or whatever six times at the end. Just moving the
		// text to here, after the method has finished everything it's going to do fixed
		// this in the most obvious (after the fact) way.
		System.out.println("\n \nThanks for playing!");
		read.close();
	}

	// The room where it happens.
	public static void roll() {
		// I wanted to keep using these until I got it right, which the long paragraph
		// above discusses. I didn't put as much effort into the try-catch loop this
		// time, but it works.
		try {
			// If the method is called to iterate again, it will add the H here. See above
			// comment about text reading differently.
			System.out.println("ow many sides will each of this pair of dice have?");
			// A properly declared variable, without any of that static nonsense. Will
			// determine how many sides the dice have.
			int numSides = read.nextInt();
			// Clears the Scanner. I'm after no shenanigans today.
			read.nextLine();
			// These guys store the actual values that represent the dice roll results. We
			// call the method twice, one for each die.
			int dieHard = 1 + generateRandomDieRoll(numSides);
			int dieHarder = 1 + generateRandomDieRoll(numSides);
			// The prompt didn't specify, but I feel like the terms "snake eyes," "box
			// cars," and "crap out" don't make much sense outside of a two 6-sided dice
			// roll game. So, I restricted those options to when the user enters 6 for the
			// number of sides.
			if (numSides == 6) {
				// result here will add the desired phrase to the end of the printing of the
				// roll results. Otherwise, it'll be blank if those conditions aren't met.
				// Further, I misread about calling this method (logic()) from another class in
				// the prompt, so this was originally written in this class and then copied to
				// the other class.
				result = DiceRollerApp.logic(dieHard, dieHarder);
			} else {
				// If we didn't enter the space, it would return a "null," making the results
				// printout look stupid.
				result = " ";
			}
			// count actually did need to be declared statically outside of the method,
			// since it needs to retain its value when the method is called again.
			count++;
			// Gives our dice roll number.
			System.out.println("Dice roll number: " + count);
			// gives our dice roll result.
			System.out.println("You rolled " + dieHard + " & " + dieHarder + "! " + result);
			// Gives user option to continue.
			System.out.println("\n\nWanna try your luck again? (Only 'y' will continue.)");
			String tryAgain = read.nextLine();

			// Will loop back to beginning
			if (tryAgain.equals("y")) {
				// Here's that 'H' I was talking about earlier.
				System.out.print("H");
				// calls back to beginning of same method.
				roll();
			}
		}
		// I'm understanding these a bit better now that I'm limiting what the catch
		// needs to do and I understand how the method calls work a bit better.
		catch (InputMismatchException comeOn) {
			// Clears Scanner.
			read.next();
			// Notice that 'H' again?
			System.out.print("\n\nCome on, stop trying to break stuff all the time! Try it again. \n\nH");
			// Calls back to same method, but with the new text.
			roll();
		}
	}

	// Mandatory method gives us the random numbers for the die rolls. takes the
	// user entered number of sides and returns the random number to represent the
	// die roll.
	private static int generateRandomDieRoll(int sides) {
		return rNGesus.nextInt(sides);
	}
	// I figured we could do everything with methods, since that's the point of this
	// practice. So there's an individual method for each phrase. These will be
	// returned based on whether a pair of 6 sided dice are rolled and their values
	// are met.
	public static String snakeEyes() {
		return "You got snake eyes!";
	}
	public static String boxCars() {
		return "A set of box cars!";
	}
	public static String craps() {
		return "Sorry, you crapped out!";
	}
}
