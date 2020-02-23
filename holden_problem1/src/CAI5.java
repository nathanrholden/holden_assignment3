import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import java.text.DecimalFormat;

import java.util.Scanner;

public class CAI5 {
	private double x;
	private double y;
	private int difficulty;
	private int problemType;
	private int currentOperator;
	Scanner input = new Scanner(System.in);
	DecimalFormat format = new DecimalFormat("##.00");

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
	{
		CAI5 quiz = new CAI5();
		quiz.quiz();
	}
	
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		int questionsCorrect = 0;
		double response;
		int booleanComplete = 0;
		
		while(booleanComplete == 0) {
			readDifficulty();
			readProblemType();
			
			for(int i = 0; i < 10; i++) { 
				this.x = generateQuestionArgument();
				this.y = generateQuestionArgument();
				
				askQuestion(secureRandomGenerator.nextInt(3));
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

	public void askQuestion(int rand) {
		switch(this.problemType) {
			case 1:
				System.out.printf("What is %.0f plus %.0f?\n", this.x, this.y);
				this.currentOperator = 1;
				break;
			case 2:
				System.out.printf("What is %.0f minus %.0f?\n", this.x, this.y);
				this.currentOperator = 2;
				break;
			case 3:
				System.out.printf("What is %.0f times %.0f?\n", this.x, this.y);
				this.currentOperator = 3;
				break;
			case 4:
				System.out.printf("What is %.0f divided by %.0f?\n", this.x, this.y);
				this.currentOperator = 4;
				break;
			case 5:
				switch(rand) {
					case 0:
						System.out.printf("What is %.0f plus %.0f?\n", this.x, this.y);
						this.currentOperator = 1;
						break;
					case 1:
						System.out.printf("What is %.0f minus %.0f?\n", this.x, this.y);
						this.currentOperator = 2;
						break;
					case 2:
						System.out.printf("What is %.0f times %.0f?\n", this.x, this.y);
						this.currentOperator = 3;
						break;
					case 3:
						System.out.printf("What is %.0f divided by %.0f?\n", this.x, this.y);
						this.currentOperator = 4;
						break;
				}
				break;
		}
	}
	
	public double readResponse() {
		double userInput = input.nextDouble();
		
		return userInput;
	}
	
	public int isAnswerCorrect(double answer, int rand) {
		switch(this.currentOperator) {
		case 1:
			if(answer == (this.x + this.y)) {
				displayCorrectResponse(rand);
				return 1;
			} else {
				displayIncorrectResponse(rand);
				return 0;
			}
		case 2:
			if(answer == (this.x - this.y)) {
				displayCorrectResponse(rand);
				return 1;
			} else {
				displayIncorrectResponse(rand);
				return 0;
			}
		case 3:
			if(answer == (this.x * this.y)) {
				displayCorrectResponse(rand);
				return 1;
			} else {
				displayIncorrectResponse(rand);
				return 0;
			}
		case 4:
			if(answer == (Math.round((this.x / this.y) * 100.0) / 100.0)) {
				displayCorrectResponse(rand);
				return 1;
			} else {
				displayIncorrectResponse(rand);
				return 0;
			}
		default:
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
	
	public double generateQuestionArgument() throws NoSuchAlgorithmException, NoSuchProviderException 
	{
		int digitgen = 1;
		double output;
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
		
		for(int i = 0; i < this.difficulty; i++) {
			digitgen *= 10;
		}
		output = secureRandomGenerator.nextInt(digitgen - 2) + 1;
		return output;
	}
	
	public void readProblemType() {
		System.out.printf("----------------------\nSelect the problem type:\n1. Addition (+)\n2. Subtraction (-)\n3. Multiplication (*)\n4. Division (/)\n5. All problem types.\n----------------------\nAnswer: ");
		this.problemType = input.nextInt();
		System.out.printf("----------------------\nRound all numbers to two decimal places!\n\n");
	}
}
