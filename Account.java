import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Account {

    protected double balance;
    protected int accountNumber;
    protected String date;
    public static String todayDate = null; // Change public to private?
    public static Bank username;

    public Account(Bank bank) {
        username = bank;
    }

    public Account() {

    }

    // Setters and getters
    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected String getDate() {
        return date;
    }

    protected void setDate(String date) {
        String dateString = date;

        // Makes sure that there the zero in the beginning is not lost
        if (dateString.length() == 7) {
            dateString = ('0' + dateString);
        }
        this.date = dateString;
    }

    protected int getAccountNumber() {
        return accountNumber;
    }

    protected void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Deducts a certain amount
    protected void withdraw(double amount) throws Exception{

        // Makes sure that they have the money to withdraw
        if (balance - amount < 0) {
            throw new Exception("Cannot withdraw amount: " + amount + " : " + balance);
        } else {
            balance -= amount;
        }

    }

    protected void deposit(double amount) throws Exception {
        balance += amount;
    }

    protected void log(String file, String date, String accountType, String accountAction, double balance, double change, String symbol) {
        File filename = new File(username + "_" + file + ".txt");
        File backupFilename = new File(username + "_" + file + ".bak.txt");

        // Copies log to a backup file
        if (filename.exists()) {
            try {
                FileReader read = new FileReader(filename);
                BufferedReader reader = new BufferedReader(read);
                FileWriter writer = new FileWriter(backupFilename, false);
                String line = reader.readLine();
                while (line != null) {
                    writer.write(line + "\n");
                    line = reader.readLine();
                }
                reader.close();
                writer.close();
            } catch (Exception e) {
                System.out.printf("%nError backup log: " + e.getMessage());
            }
        }

        // Makes new log with new change
        try {

            FileWriter writer = new FileWriter(filename, false);

            writer.write(todayDate + ": " + accountType + " " + accountAction + ": " + balance +  " " + symbol + change + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.printf("%nError log: " + e.getMessage());
        }

        // Copies back up file to recent log file (so most recent activity is on top)
        if (backupFilename.exists()) {
            try {

                FileReader read = new FileReader(backupFilename);
                BufferedReader reader = new BufferedReader(read);
                FileWriter writer = new FileWriter(filename, true);
                String line = reader.readLine();
                while (line != null) {
                    writer.write(line + "\n");
                    line = reader.readLine();
                }
                reader.close();
                writer.close();

            } catch (Exception e) {
                System.out.printf("%nError new log: " + e.getMessage());
            }
        }



    }

}
