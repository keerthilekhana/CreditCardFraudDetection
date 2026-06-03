import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Credit Card Fraud Detection =====");

        System.out.print("Enter Transaction Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Number of Transactions Today: ");
        int transactionsToday = sc.nextInt();

        System.out.print("Foreign Transaction? (true/false): ");
        boolean foreignTransaction = sc.nextBoolean();

        boolean fraud =
                FraudDetector.isFraud(
                        amount,
                        transactionsToday,
                        foreignTransaction);

        if (fraud) {
            System.out.println("\n⚠ Fraudulent Transaction Detected");
        } else {
            System.out.println("\n✓ Transaction is Safe");
        }

        sc.close();
    }
}