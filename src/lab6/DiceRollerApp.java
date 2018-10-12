package lab6;

public class DiceRollerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String logic(int dieHard, int dieHarder) {
		 if ((dieHard + dieHarder) == 12) {
			 return Lab6RandomNumberGod.boxCars();
		 }
		 else if ((dieHard + dieHarder) == 2) {
			 return Lab6RandomNumberGod.snakeEyes();
		 }
		 else if ((dieHard + dieHarder) == 7) {
			 return Lab6RandomNumberGod.craps();
		 } 
		 else {
			 return " ";
		 }
	}

}
