import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import java.util.Scanner;

public class CAI4 {
	private int x;
	private int y;
	private int difficulty;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
	{
		CAI4 quiz = new CAI4();
		quiz.quiz();
	}
	
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		int questionsCorrect = 0;
		int response;
		int booleanComplete = 0;
		
		while(booleanComplete == 0) {
			readDifficulty();
			
			for(int i = 0; i < 10; i++) { 
				this.x = generateQuestionArgument();
				this.y = generateQuestionArgument();
				
				askQuestion();
				response = readResponse();
				
				if(isAnswerCorrect(response, secureRandomGenerator.nextInt(3)) == 1){
					questionsCorrect++;
				}
			}
			
			displayCompletionMessage(questionsCorrect);
			if(readResponse() != 1) {
				booleanComplete = 1;
			}
			System.out.printf("\n\n");
			questionsCorrect = 0;
			
		}
		
		input.close();
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
	
	public static void displayCompletionMessage(int complete) {
		double percent = complete * 10;
		if(percent >= 75) {
			System.out.printf("Your Score: %.0f%%", percent);
			System.out.printf("\nCongragulations, you are ready to go to the next level!\n\n");
		} else {
			System.out.printf("Your Score: %.0f%%", percent);
			System.out.printf("\nPlease ask your teacher for extra help.\n\n");
		}
		
		System.out.printf("Would you like another problem set? (Y = 1 / N = 0): ");
	}
	
	public void readDifficulty() {
		System.out.printf("Select the difficulty:\n1. 1 digit numbers.\n2. 2 digit numbers.\n3. 3 digit numbers.\n4. 4 digit numbers.\n----------------------\nAnswer: ");
		this.difficulty = input.nextInt();
	}
	
	public int generateQuestionArgument() throws NoSuchAlgorithmException, NoSuchProviderException 
	{
		int digitgen = 1;
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		
		for(int i = 0; i < this.difficulty; i++) {
			digitgen *= 10;
		}
		
		return secureRandomGenerator.nextInt(digitgen - 1);
	}
}
