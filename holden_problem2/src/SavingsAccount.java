
public class SavingsAccount {
	
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		double monthlyInterestRate = annualInterestRate / 12;
		savingsBalance = savingsBalance + (savingsBalance * monthlyInterestRate);
		System.out.printf("%.2f\n", savingsBalance);
	}
	
	public static void modifyInterestRate(double interestRate) {
		annualInterestRate = interestRate;
	}
}
