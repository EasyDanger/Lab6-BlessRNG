package lab6;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lab6RandomNumberGod {
	static Random rNJesus = new Random();
	static String result;
	static int count;
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Hi. Welcome to the Grand Circus Casino! \n\nWe're totally zoned for this and everything is legal! (Enter to continue) ");
		read.nextLine();
		System.out.println("We're going to roll a pair of dice, and see what your luck says. (Enter) ");
		read.nextLine();
		System.out.print("First, h");
		roll();
		System.out.println("\n \nThanks for playing!");
	}
	public static void roll() {
try {
		System.out.println("ow many sides will each of this pair of dice have?");
		int numSides = read.nextInt();
		read.nextLine();
		
		int dieHard = 1 + generateRandomDieRoll(numSides);
		int dieHarder = 1 + generateRandomDieRoll(numSides);
		
		if (numSides == 6) {
			result = DiceRollerApp.logic(dieHard, dieHarder);
		}
		else {
			result = " ";
		}
		count++;
		System.out.println("Dice roll number: " + count);
		System.out.println("You rolled " + dieHard + " & " + dieHarder + "! " + result);	
		System.out.println("\n\nWanna try your luck again? (y/n)");
		String tryAgain = read.nextLine();

		if (tryAgain.equals("y")) {
		System.out.print("H");
			roll();
		}

}
		catch (InputMismatchException comeOn) {
			System.out.println("\n\nCome on, stop trying to break stuff all the time! Do it again.");
			read.close();
			roll();

		}

	}

	private static int generateRandomDieRoll(int sides) {
		return rNJesus.nextInt(sides);
	}
	
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
