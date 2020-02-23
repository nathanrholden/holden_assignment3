import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import java.util.Scanner;

public class CAI2 {
	private int x;
	private int y;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
	{
		CAI2 quiz = new CAI2();
		quiz.quiz();
	}
	
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		this.x = (secureRandomGenerator.nextInt(9));
		this.y = (secureRandomGenerator.nextInt(9));
		
		askQuestion();
		int response = readResponse();
		
		while(isAnswerCorrect(response, secureRandomGenerator.nextInt(3)) == 0) {
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
	
	public int isAnswerCorrect(int answer, int rand) {
		if(answer == (this.x * this.y)) {
			displayCorrectResponse(rand);
			return 1;
		} else {
			displayIncorrectResponse(rand);
			return 0;
		}
	}
	
	public void displayCorrectResponse(int rand) {
		switch(rand) {
			case 0:
				System.out.println("Very Good!");
				break;
			case 1:
				System.out.println("Excellent!");
				break;
			case 2:
				System.out.println("Nice work!");
				break;
			case 3:
				System.out.println("Keep up the good work!");
				break;
			default:
		}
		
		input.close();
	}
	
	public static void displayIncorrectResponse(int rand) {
		switch(rand) {
		case 0:
			System.out.println("No. Please try again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don't give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		default:
		}
	}
}
