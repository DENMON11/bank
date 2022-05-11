public class Savings extends Account {

    private final double INTEREST = .02;
    public final String FILENAME = "savings";

    public Savings() {

    }

    public double getInterest() {
        return INTEREST;
    }

    public void addInterest(String username) {

        // Loops so that each month is accounted for
        while (true) {
            double change = (balance * INTEREST); // Records what the change will be

            // If last date was December
            if (date.charAt(0) == '1' && date.charAt(1) == '2') {
                if ((Integer.parseInt(date) - 11000000) < Integer.parseInt(todayDate)) {
                    date = Integer.toString(Integer.parseInt(date) - 11000000);
                } else {
                    break;
                }

            } else if ((Integer.parseInt(date) + 1000000) < Integer.parseInt(todayDate)) {
                // Sees if a month has passed and adds interest
                date = Integer.toString(Integer.parseInt(date) + 1000000);

            } else {
                break;
            }

            // If it reaches here, it will update stuff and log it
            balance += change;
            log(FILENAME,
                    date,
                    "Savings",
                    "interest",
                    balance,
                    change,
                    "+");

        }
    }

    @Override
    public String toString() {
        String balance = String.format("%,.2f", this.balance);
        String accountString = Integer.toString(getAccountNumber());
        return ("\nSavings Balance (****" +
                accountString.charAt(5) +
                accountString.charAt(6) +
                accountString.charAt(7) +
                accountString.charAt(8) +
                "): $" +
                balance);
    }

}
