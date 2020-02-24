
public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.print("saver1 balance: ");
		saver1.calculateMonthlyInterest();
		System.out.print("saver2 balance: ");
		saver2.calculateMonthlyInterest();
		
		SavingsAccount.modifyInterestRate(0.05);
		System.out.println();
		
		System.out.print("saver1 balance: ");
		saver1.calculateMonthlyInterest();
		System.out.print("saver2 balance: ");
		saver2.calculateMonthlyInterest();
	}

}
