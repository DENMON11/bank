public class Credit extends Account{

    private final double INTEREST = 1.1,
        MIN_PAYMENT = 50;
    public final String FILENAME = "credit";
    private double creditLine, rewards = 0.0, rewardRate, statement = 0.0, amountPaid = 0.0, creditScore = 650, requestLine = 0.0;
    private String billDate = "null", creditIncreaseDate = "null", startingDate;
    // Some strings are set to "null" so when this data is saved, an error doesn't occur for trying to save
    // a null variable. I could have it so that it sees if a variable is null before trying to save it, but then
    // the layout of the save file might get messed up
    private boolean minPaymentMet = true, request = false;

    public Credit() {

    }

    // Setters and Getters
    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    public double getRewards() {
        return rewards;
    }

    public void setRewards(Double rewards) {
        this.rewards = rewards;
    }

    public void addRewards(double rewards) {
        this.rewards += rewards;
    }

    public double getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(double rewardRate) {
        this.rewardRate = rewardRate;
    }

    public double getStatement() {
        return statement;
    }

    public void setStatement(double statement) {
        this.statement = statement;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getCreditIncreaseDate() {
        return creditIncreaseDate;
    }

    public void setCreditIncreaseDate(String creditIncreaseDate) {
        this.creditIncreaseDate = creditIncreaseDate;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public double getMIN_PAYMENT() {
        return MIN_PAYMENT;
    }

    public void setMinPaymentMet(boolean minPaymentMet) {
        this.minPaymentMet = minPaymentMet;
    }

    public boolean getMinPaymentMet() {
        return minPaymentMet;
    }

    public void setAmountPaid(double amount) {
        amountPaid = amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    public boolean getRequest() {
        return request;
    }

    public void setRequestLine(double requestLine) {
        this.requestLine = requestLine;
    }

    public double getRequestLine() {
        return requestLine;
    }

    // Adds to the credit score instead of setting it
    public void addCreditScore(double amount) {
        creditScore += amount;
        if (creditScore < 300 || creditScore > 850) {
            creditScore -= amount;
        }
    }

    public void purchase(double amount) throws Exception {
        withdraw(amount);
        addRewards(amount * rewardRate);
    }

    public void setStatement(String username) {

        // Loops so that each month is accounted for
        while (true) {
            // Records change
            double change = (balance * (INTEREST - 1));

            // Makes sure that it is formatted correctly
            if (billDate.length() == 7) {
                billDate = ('0' + billDate);
            }
            if (todayDate.length() == 7) {
                todayDate = ('0' + todayDate);
            }

            // For logging purposes
            String placeholderDate = billDate;

            // Changed formatting to make comparisons easier to make
            String newBillDate = Character.toString(billDate.charAt(4)) +
                    billDate.charAt(5) +
                    billDate.charAt(6) +
                    billDate.charAt(7) +
                    billDate.charAt(0) +
                    billDate.charAt(1) +
                    billDate.charAt(2) +
                    billDate.charAt(3);
            String newTodayDate = Character.toString(todayDate.charAt(4)) +
                    todayDate.charAt(5) +
                    todayDate.charAt(6) +
                    todayDate.charAt(7) +
                    todayDate.charAt(0) +
                    todayDate.charAt(1) +
                    todayDate.charAt(2) +
                    todayDate.charAt(3);

            // If last date was December
            if (billDate.charAt(0) == '1' && billDate.charAt(1) == '2') {
                if ((Integer.parseInt(newBillDate) - 11000000) < Integer.parseInt(newTodayDate)) {

                    // Updates date
                    billDate = Integer.toString(Integer.parseInt(billDate) - 11000000 + 1);

                    if (billDate.length() == 7) {
                        billDate = ('0' + billDate);
                    }

                } else {
                    break;
                }

            } else if ((Integer.parseInt(newBillDate)) <= Integer.parseInt(newTodayDate)) {

                // Updates date
                billDate = Integer.toString(Integer.parseInt(billDate) + 1000000);

                // To ensure correct formatting
                if (billDate.length() == 7) {
                    billDate = ('0' + billDate);
                }

            } else {
                break;
            }

            // If it reaches here, updates statement and adds interest if the statement is not paid in time
            amountPaid = 0;
            if (statement == 0) {
                statement = balance;
            } else {

                // If the minimum payment is met, then the interest doesn't apply
                if (minPaymentMet) {
                    statement = balance;
                    minPaymentMet = false;
                } else {
                    balance *= INTEREST;
                    statement = balance;
                }
            }

            // Logs information
            log(FILENAME,
                    placeholderDate,
                    "Credit",
                    "Interest",
                    balance,
                    change,
                    "+");

        }
    }

    // Customer has to wait three days for a response, and the response will be based on the credit score
    // and the amount requested
    public void requestCreditLine(double amount) {
        request = true;
        requestLine = amount;
        creditIncreaseDate = todayDate;

        // Just to make sure that the format is correct
        if (creditIncreaseDate.length() == 7) {
            creditIncreaseDate = ('0' + creditIncreaseDate);
        }

        int answerDay = Integer.parseInt(Character.toString(creditIncreaseDate.charAt(2)) + creditIncreaseDate.charAt(3));

        // Finds what the day will be in three days
        answerDay += 3;
        int placeholder = answerDay;
        boolean looped = false; // This will tell me if in three days the counter will reset
        while (placeholder > 31) {
            looped = true;
            if (placeholder == answerDay) {
                placeholder--;
                answerDay = 1;
            } else{
                placeholder--;
                answerDay++;
            }
        }

        // This will set a variable to be three days in the future so the credit line increase can be determined after
        // that time
        if (!looped) {
            int answerDate = (Integer.parseInt(creditIncreaseDate) + 30000);
            creditIncreaseDate = Integer.toString(answerDate);
            if (creditIncreaseDate.length() == 7) {
                creditIncreaseDate = ('0' + creditIncreaseDate);
            }
        } else {
            creditIncreaseDate.replace(creditIncreaseDate.charAt(2), '0');
            creditIncreaseDate.replace(creditIncreaseDate.charAt(3), (char) answerDay);
        }

    }

    // This checks if it is time to make a decision for the credit line request
    public boolean checkCreditIncreaseDate() {

        // Makes sure that the format is correct
        if (todayDate.length() == 7) {
            todayDate = ('0' + todayDate);
        }

        // Gets the year, day, and month for both dates to compare them
        String thisMonth = Character.toString(todayDate.charAt(0)) +
                todayDate.charAt(1);
        String creditMonth = Character.toString(creditIncreaseDate.charAt(0)) +
                creditIncreaseDate.charAt(1);
        String thisDay = Character.toString(todayDate.charAt(2)) +
                todayDate.charAt(3);
        String creditDay = Character.toString(creditIncreaseDate.charAt(2)) +
                creditIncreaseDate.charAt(3);
        String thisYear = Character.toString(todayDate.charAt(4)) +
                todayDate.charAt(5) +
                todayDate.charAt(6) +
                todayDate.charAt(7);
        String creditYear = Character.toString(creditIncreaseDate.charAt(4)) +
                creditIncreaseDate.charAt(5) +
                creditIncreaseDate.charAt(6) +
                creditIncreaseDate.charAt(7);

        // Checks if the current date is at least three days in the future
        // Years
        if (Integer.parseInt(thisYear) > Integer.parseInt(creditYear)) {

            // This checks if the date requested was after December 28 and acts accordingly
            if (Integer.parseInt(creditMonth) == 12 && Integer.parseInt(creditDay) > 28) {

                // Counts the number of days before the end of the month and makes sure that
                // the current day is three days later despite being a new month
                int counter = 0;
                int placeholder = Integer.parseInt(creditDay);
                while(placeholder > 28) {
                    counter++;
                    placeholder--;
                }
                if (Integer.parseInt(thisDay) >= counter ) {
                    return true;
                } else {
                    return false;
                }

                // Well in the future
            } else {
                return true;
            }

            // Months
        } else if (Integer.parseInt(thisMonth) > Integer.parseInt(creditMonth)) {

            // This checks late days in the months to make sure that the date in the next month is valid
            if (Integer.parseInt(thisMonth) - Integer.parseInt(creditMonth) == 1 && Integer.parseInt(creditDay) > 28) {

                // Counts the number of days before the end of the month and makes sure that
                // the current day is three days later despite being a new month
                int counter = 0;
                int placeholder = Integer.parseInt(creditDay);
                while (placeholder > 28) {
                    counter++;
                    placeholder--;
                }
                if (Integer.parseInt(thisDay) >= counter) {
                    return true;
                } else {
                    return false;
                }

                // Well in the future
            } else {
                return true;
            }

            // Days
        } else if (Integer.parseInt(thisDay) > (Integer.parseInt(creditDay) + 3)) {
            return true;

            // The current date is not three days after the credit line increase date if it reaches below
        } else {
            return false;
        }
    }

    // When the time comes, this processes the credit line request amount
    public boolean answerCreditLine() {

        // This determines how much money the person requests
        // The more they request, the higher their credit score needs to be
        double baseValue = 690;
        double requestAmount = requestLine - creditLine;
        int counter = 0;
        while (requestAmount > 100) {
            baseValue += 10;
            counter++;
            requestAmount -= 100;
        }

        // Returns to defaults
        creditIncreaseDate = "null";
        request = false;

        // Based on the credit score they expect you to have,
        // and how much money you are requesting, this will determine
        // if you get the increase or not.
        if (baseValue <= creditScore) {
            creditLine = requestLine;
            requestLine = 0.0;
            creditScore -= (counter * 4);

            // This makes sure that the credit score never goes under the lowest amount (300)
            if (creditScore < 300) {
                creditScore = 300;
            }

            return true;
        } else {
            requestLine = 0.0;
            return false;
        }

    }

    // Is this working as intended?
    // The values for credit accounts are mixed because it keeps tracks of the
    // amount of money you spent not the balance
    @Override
    public void withdraw(double amount) throws Exception {

        if (balance + amount > creditLine) {
            throw new Exception("Cannot withdraw amount: " + amount + " : " + getBalance());
        } else {
            balance += amount;
        }

    }

    public void deposit(double amount) throws Exception {
        if (balance - amount < 0) {
            throw new Exception("Cannot deposit amount: " + amount + " : " + getBalance());
        } else {
            balance -= amount;
        }
    }

    public String toString() {
        String balance = String.format("%,.2f", this.balance);
        String accountString = Integer.toString(getAccountNumber());
        return ("\nCredit (****" +
                accountString.charAt(5) +
                accountString.charAt(6) +
                accountString.charAt(7) +
                accountString.charAt(8) +
                ") (Credits Spent): $" +
                balance);
    }

}
