public class FraudDetector {

    public static boolean isFraud(double amount,
                                  int transactionsToday,
                                  boolean foreignTransaction) {

        if (amount > 50000) {
            return true;
        }

        if (transactionsToday > 10) {
            return true;
        }

        if (foreignTransaction) {
            return true;
        }

        return false;
    }
}