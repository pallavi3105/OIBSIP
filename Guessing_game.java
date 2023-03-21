import java.util.Scanner;
public class Guessing_game 
{
    public static void GNgame()
	{
		Scanner sc = new Scanner(System.in);
		int number = 1 + (int)(100 * Math.random());
		int K = 5;
		int i, guess;

		System.out.println("--------------------------------Guessing Number Game---------------------------------------------\n");
		System.out.println("\tA number is chosen between 1 to 100. Guess the number within 5 trials.");
		for (i = 0; i < K; i++) {
            System.out.println("\tGuess the number:");
			guess = sc.nextInt();

			if (number == guess) {
				System.out.println("\tCongratulations! You guessed the number.");
				break;
			}
			else if (number > guess && i != K - 1) {
				System.out.println("\tThe number is greater than " + guess  +"\n");
			}
			else if (number < guess && i != K - 1) {
				System.out.println("\tThe number is less than " + guess +"\n");
			}
		}
		if (i == K) {
			System.out.println("\n\tYou have exhausted " +  K  +" trials." + "\n\tBetter Luck Next Time\n");
			System.out.println("\tThe number was " + number + "\n");
		}
	}
	public static void main(String arg[])
	{
		GNgame();
	}
}
