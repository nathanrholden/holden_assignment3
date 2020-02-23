import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import java.util.Scanner;

public class CAI1 {
	private int x;
	private int y;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
	{
		CAI1 quiz = new CAI1();
		quiz.quiz();
	}
	
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		this.x = (secureRandomGenerator.nextInt(9));
		this.y = (secureRandomGenerator.nextInt(9));
		
		askQuestion();
		int response = readResponse();
		
		while(isAnswerCorrect(response) == 0) {
			response = readResponse();
		}
	}

	public void askQuestion() {
		System.out.printf("What is %d times %d?\n", this.x, this.y);
	}
	
	public int readResponse() {
		int userInput = input.nextInt();
		
		return userInput;
	}
	
	public int isAnswerCorrect(int answer) {
		if(answer == (this.x * this.y)) {
			displayCorrectResponse();
			return 1;
		} else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public void displayCorrectResponse() {
		System.out.println("Very Good!");
		input.close();
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
}
