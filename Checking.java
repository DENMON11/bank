public class Checking extends Account {

    public final String FILENAME = "checking";

    public Checking() {

    }

    public void purchase(double amount) throws Exception {
        withdraw(amount);
    }

    @Override
    public String toString() {
        String balance = String.format("%,.2f", this.balance);
        String accountString = Integer.toString(getAccountNumber());
        return ("\nChecking Balance (****" +
                accountString.charAt(5) +
                accountString.charAt(6) +
                accountString.charAt(7) +
                accountString.charAt(8) +
                "): $" +
                balance);
    }

}
