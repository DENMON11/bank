// Program: BankClient.java
// Written by: Dennis Monich
// Description: Will simulate a real banking experience
// Challenges: Creating a file and saving information there was a new concept to me.
//              There was also a lot of bugs that took some times to figure out
// Time Spent: Wasn't keeping track, but a lot. Altogether, probably around 48 hours.
//
//                   Revision History
// Date:                   By:               Action:
// ---------------------------------------------------
// 4/10/22                  DVM             Started creating a file with different usernames.
//                                          I set up different variables and methods based on the UML
// 4/10/22                  DVM             Started another file that will store all useful information and encrypt it.
// 4/11/22                  DVM             Worked on having the save method to include all necessary information.
//                                          (Before I just had I save the username and password for testing purposes)
//                                          Moved the encryption method to this class for ease of access
//                                          Added a method to encrypt booleans
//                                          Started asking the user prompts for using their accounts
// 4/13/22                  DVM             Fixed some encrypting and prompt bugs
// 4/16/22                  DVM             Asked for what account someone wants to use. Added interest method to
//                                          savings account and add a log method to Account so that user can have
//                                          access to what changes were made to their balances. It is not encrypted as
//                                          of right now. Changed date variable to a String from now on to account for
//                                          when the first character must be a '0'.
// 4/17/22                  DVm             Updated how logging worked. Created prompts for whoever wants to user their
//                                          checking account. At first the prompts seemed repetitive, so I condensed it
//                                          as much as I could so that way less code is used overall (at the expense of
//                                          readability). I still need to make some methods and variables for savings
//                                          and credit classes.
// 4/18/22                  DVM             Started working on the prompts and setting up varablies for when someone
//                                          selects a savings account. Credit accounts and savings accounts should be
//                                          okay to open now, but I need to update the save file to include information
//                                          from variables that I had to add.
// 4/19/22                  DVM             Continued progress on the savings account prompts. I just need to add the
//                                          success messages
// 4/24/22                  DVM             Finished the prompts for when both the "savings" and "credit"
//                                          options are selected. Added a way to validate the user input for today's
//                                          date by not only checking the format and the numbers used but also checking
//                                          that the new date is not before the last date. I still need to apply the
//                                          date to the savings and credit account so interest and bill can be set up.
// 4/30/22                  DVM             Made sure that the date was being saved properly and choosing a date
//                                          every time the program ran worked properly. Started working on credit
//                                          methods in more detail. Finished setStatement() and the methods associated
//                                          with requesting a new credit line amount. Also added new variables that
//                                          could play a role in the mentioned methods, such as creditScore, request,
//                                          and more. Added setters and getters for those. Added a final variable
//                                          that has to do with the minimum payment necessary for each statement
//                                          and added methods and other variables that had to do with the minimum
//                                          payment. Edited transfers in this class to account for the statement
//                                          in the credit account and how the transfers will be used to pay for the
//                                          statement. This all still needs to be tested, but I also need to save
//                                          all the new variables every time the program is closed so it can be tested
//                                          properly. For tomorrow!
// 5/1/22                   DVM             I have most of the methods for the credit account and added methods such as
//                                          checkCreditLineIncrease(). Started working on the prompts for the credit
//                                          account. Every time the program is run and the user enters the date, the
//                                          program checks for statements and credit line increase dates and acts
//                                          accordingly. Now testing is mostly what needs to be done. I need to add a
//                                          toString method to each account that displays balance and other info.
// 5/2/22                   DVM             I'm close to the debugging phase. I've finished transferring credit rewards
//                                          I added composition between Account and Bank since Account needs the
//                                          username variable. Added toString methods to each account to make it
//                                          simpler to display balance. As I debug, I need to look at the instruction
//                                          sheet to make sure I nailed everything.
// 5/2/22                   DVM             I created a chart with all the stuff that I need to test to make sure
//                                          every prompt appears and every input from user is account for. Will need to
//                                          finish debugging. Chart is found below line.
// 5/3/22                   DVM             Debugging. Still working on making sure every prompt works. Edited
//                                          toString methods to have better formatting. Fixed setStatement(String)
//                                          method to properly compare dates by making new variables with a different
//                                          format.
// 5/4/22                   DVM             Now we are logging when an account opens. Added a way to display the logs
//                                          in the program. It just needs testing now.
// 5/6/22                   DVM             Everything is tested and fixed for bugs. Should work flawlessly now.

// ----------------------------------------------------------------------------------------------------------------- //
// Below is to make sure that everything is working as intended

// New account: Working
    // Username: Working
        // Less characters: Working
        // More characters: Working
        // Valid: Working
        // Quit: Working
    // Password: Working
        // Less character: Working
        // More characters: Working
        // Valid: Working
        // Quit: Working
// Enter Username: Working
    // Correct username: Working
        // Wrong username: Working
    // Quit: Working
    // New: Working
// Enter Password: Working
    // Correct: Working
    // Misinput: Working
        // Misinput x5: Working
    // Quit: Working?            <-- Doesn't display "You have quit." message
// Today's Date: Working as Intended
    // Wrong format: Working
    // Time in the past: Working
        // Old year: Working
        // Old day: Working
        // Old month: Working
    // Same day: Working
    // Time in the future: Working
    // Quit: Working
// Credit Line Increase Request:
    // When it's not time: Working
    // When it's exactly on time: Working
    // When it's in the future: Working
// Statement: Working
    // Before one month: Working
    // After one month; already paid: Working
    // After one month; minimum payment met: Working
    // After one month; not enough paid: Working Working
    // After many months; already paid: Working
    // After many months; minimum payment met: Working
    // After many months; not enough paid: Working
// Select Account:
    // Checking: Working
        // Deposit: Working
            // Wrong format: Working
            // Negative number: Working
            // Positive number: Working
            // Quit: Working
            // Cancel: Working
        // Withdraw: Working
            // Wrong format: Working
            // Negative number: Working
            // Positive Number: Working
            // More than balance: Working
            // Quit: Working
            // Cancel: Working
        // Purchase: Working
            // Wrong format: Working
            // Negative number: Working
            // Positive number: Working
            // More than balance: Working
            // Quit: Working
            // Cancel: Working
            // Select item: Working
                // String: Working
                // Quit: Working
                // Cancel: Working
        // Transfer:
            // With no account to transfer to: Working
            // Amount: Working
                // Negative number: Working
                // Misinput: Working
                // More than balance: Working
                // Cancel : Working
                // Quit: Working
                // Account: Working
                    // Savings: Working
                    // Credit: Working
                        // More than credit spent: Working
                    // Cancel: Working
                    // Quit: Working
                    // Misinput: Working
            // Quit: Working
            // Cancel: Working
        // Log: Working
            // Negative number: Working
            // A few lines: Working
            // More lines than in the file: Working
            // Misinput: Working
            // Cancel: Working
            // Quit: Working
        // Quit: Working
        // Cancel: Working
        // Misinput: Working
    // Savings: Working
        // Deposit: Working
            // Wrong format: Working
            // Negative number: Working
            // Positive number: Working
            // Cancel: Working
            // Quit: Working
        // Withdraw: Working
            // Wrong format: Working
            // Negative number: Working
            // Positive number: Working
            // More than balance: Working
            // Quit: Working
            // Cancel: Working
        // Transfer: Working
            // Negative number: Working
            // Wrong format: Working
            // Positive number: Working
                // Checking: Working
                // Credit: Working
                // Misinput: Working
            // More than balance: Working
            // Quit: Working
            // Cancel: Working
        // Log: Working
            // Negative number: Working
            // A few lines: Working
            // More lines than in the file: Working
            // Misinput: Working
            // Cancel: Working
            // Quit: Working
        // Quit: Working
        // Cancel: Working
        // Misinput: Working
    // Credit: Working
        // Purchase (y/Y): Working
            // Negative number: Working
            // Wrong format: Working
            // Positive number: Working
            // More than balance: Working
            // Quit: Working
            // Cancel: Working
            // Item: Working
                // String: Working
                // Quit: Working
                // Cancel: Working
                // Misinput: Working
        // More: Working
            // Review statement: Working
            // Request credit line increase: Working
                // Less than current credit line: Working
                // Misinput: Working
                // Valid number: Working
                // Quit: Working
                // Cancel: Working
                // When request is already made: Working
            // Claim rewards: Working
                // Claim without savings account: Working
                // Claim with savings account: Working
                    // Checking: Working
                    // Savings: Working
                    // Quit: Working
                    // Cancel: Working
                    // Misinput: Working
                // With no rewards: Working
            // Log: Working
                // Negative number: Working
                // A few lines: Working
                // More lines than in the file: Working
                // Misinput: Working
                // Cancel: Working
                // Quit: Working
            // Quit: Working
            // Cancel: Working
            // Misinput: Working
        // Quit: Working
        // Misinput:
    // Open Savings: Working
    // Open Credit: Working
    // Quit: Working
    // Misinput: Working

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class BankClient {

    private static final String USER_FILE = "usernames.txt"; // Name of the file with all usernames

    // This helps with creating account numbers.
    private static final int ACCOUNT_NUMBER_LENGTH = 6;
    private static final String CHECKING_PREFIX = "112",
        SAVINGS_PREFIX = "120",
        CREDIT_PREFIX = "233";
    public static final String DEFAULT_ERROR = "Please try again: ";

    public static void main(String[] args) throws Exception {

        // This will help make sure that the user is inputting the correct input
        boolean valid;

        // Sets up specific variables for when the user decides to do anything with the account
        enum Action {
            WITHDRAW,
            DEPOSIT,
            PURCHASE,
            TRANSFER,
        }

        // Allows input
        Scanner input = new Scanner(System.in);

        // RNG
        Random random = new Random();

        // Constructors
        Bank bank = new Bank();
        Checking checking = new Checking();
        Savings savings = new Savings();
        Credit credit = new Credit();

        // Welcomes user
        System.out.print("Welcome to Banking Simulator 2022. (Type \"quit\" anytime to save and quit)");

        // If this is the first time this program has ever been run, an account needs to be created
        File fileName = new File(USER_FILE);
        boolean newAccount = false; // For when user wants to make a new account when selecting username
        boolean quit = false; // For quitting
        boolean selectedUser = false;
        if (fileName.exists()) {

            // Asks to choose a username
            System.out.printf("%nSelect one of the following usernames, or type \"new\" to make a new account.");

            // Lists the username
            ArrayList <String> usernames = new ArrayList<>();
            try {
                FileReader fstream = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fstream);
                String line = reader.readLine();
                while (line != null) {
                    System.out.print("\n" + line);
                    usernames.add(line);
                    line = reader.readLine();
                }
                reader.close();
                System.out.println();
            } catch (Exception e) {
                System.out.print("Error: " + e.getMessage());
            }

            // Records what the user chooses
            String username = "", choice = "";


            // Responds accordingly
            do {
                valid = true;
                choice = input.nextLine();

                for (String s : usernames) {
                    if (choice.equalsIgnoreCase(s)) {

                        // Gets the following information from the correct file
                        selectedUser = true;
                        username = s;
                        File user = new File(username + ".txt");
                        try {
                            FileReader fstream = new FileReader(user);
                            BufferedReader reader = new BufferedReader(fstream);
                            String info = reader.readLine();
                            bank.setUsername(encrypt(info, false));
                            info = reader.readLine();
                            bank.setPassword(encrypt(info, false));
                            info = reader.readLine();
                            bank.setOpenSavings(decryptBoolean(info));
                            info = reader.readLine();
                            bank.setOpenCredit(decryptBoolean(info));
                            info = reader.readLine();
                            checking.setBalance(Double.parseDouble(encrypt(info, false)));
                            info = reader.readLine();
                            checking.setAccountNumber(Integer.parseInt(encrypt(info, false)));
                            if (bank.getOpenSavings()) {
                                info = reader.readLine();
                                savings.setBalance(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                savings.setAccountNumber(Integer.parseInt(encrypt(info, false)));
                                info = reader.readLine();
                                savings.setDate(encrypt(info, false));
                            }
                            if (bank.getOpenCredit()) {
                                info = reader.readLine();
                                credit.setBalance(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setAccountNumber(Integer.parseInt(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setDate(encrypt(info, false));
                                info = reader.readLine();
                                credit.setStartingDate(encrypt(info, false));
                                info = reader.readLine();
                                credit.setCreditLine(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setCreditIncreaseDate(encrypt(info, false));
                                info = reader.readLine();
                                credit.setRequest(decryptBoolean(info));
                                info = reader.readLine();
                                credit.setRequestLine(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setRewards(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setRewardRate(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setStatement(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setAmountPaid(Double.parseDouble(encrypt(info, false)));
                                info = reader.readLine();
                                credit.setMinPaymentMet(decryptBoolean(info));
                                info = reader.readLine();
                                credit.setBillDate(encrypt(info, false));
                                info = reader.readLine();
                                credit.setCreditScore(Double.parseDouble(encrypt(info, false)));
                            }
                            info = reader.readLine();
                            bank.setLastDate(encrypt(info, false));
                            reader.close();
                        } catch (Exception e) {
                            System.out.print("\nError: Line 131 " + e.getMessage());
                        }

                    }
                }

                // This if statement is needed so the above can loop first then test for other values after
                if (username.equalsIgnoreCase("")) {
                    if (choice.equalsIgnoreCase("new")) {

                        // The process for a new account is made
                        newAccount = true;
                        break;
                    } else if (choice.equalsIgnoreCase("quit")) {
                        quit = true;
                        break;
                    } else {
                        if ((!selectedUser && !quit && !newAccount) || username.equals("")) {
                            valid = false;
                            System.out.printf("%n%s",
                                    DEFAULT_ERROR);
                        }
                    }
                }
            } while (!valid);

            // Asks for the password
            String password = "";
            if (!choice.equalsIgnoreCase("quit") &&
                    !choice.equalsIgnoreCase("new") && fileName.exists()) {
                System.out.printf("%nInput your password: ");
                int counter = 0; // Counts the number of times that the user failed
                password = input.nextLine();

                // Checks the password
                do {
                    valid = true;
                    if (password.equalsIgnoreCase("quit")) {
                        quit = true;
                        break;
                    } else if (!password.equals(bank.getPassword())) {
                        valid = false;
                        counter++;
                        if (counter == 3) {
                            System.out.printf("%nYou have two more tries. Please try again: ");
                        } else if (counter == 4) {
                            System.out.printf("%nYou have one more try. Please try again: ");
                        } else if (counter == 5) {
                            System.out.printf("%nYou have been locked out of this account.");
                            quit= true;
                            break;
                        } else System.out.printf("%n%s",
                                DEFAULT_ERROR);
                        password = input.nextLine();
                    } else break;
                } while (!valid);
            }


        }

        // For storing responses
        String response = "";

        // Make a new account
        if (!fileName.exists() || newAccount) {

            // Creates a username for the first account
            System.out.printf("%nLet's create an account. Type in a username of your liking. " +
                    "%nIt must between 4-20 characters: ");

            // Makes sure that the input was valid and records it
            do {
                valid = true;
                response = input.nextLine();
                if (response.length() < 4 || response.length() > 20) {
                    valid = false;
                    System.out.printf("%n%s",
                            DEFAULT_ERROR);
                } else if (response.equalsIgnoreCase("quit")) {
                    break;
                } else {
                    bank.setUsername(response);
                }
            } while (!valid);

            if (!response.equalsIgnoreCase("quit")) {
                // Creates a password for the first account
                System.out.printf("%nType in a password of your liking. Make sure that it is secure!!!" +
                        "%nIt must between 8-20 characters: ");

                // Makes sure that the input was valid and records it
                do {
                    valid = true;
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("quit")) {
                        break;
                    } else if (response.length() < 8 || response.length() > 20) {
                        valid = false;
                        System.out.printf("%n%s",
                                DEFAULT_ERROR);
                    } else {
                        bank.setPassword(response);
                    }
                } while (!valid);


                if (!response.equalsIgnoreCase("quit")) {
                    // Records the username
                    try {
                        FileWriter fstream = new FileWriter(fileName, true);
                        fstream.write(bank.getUsername() + "\n");
                        fstream.close();
                    } catch (Exception e) {
                        System.out.print("Error: " + e.getMessage());
                    }

                    // Creates default settings
                    bank.setOpenCredit(false);
                    bank.setOpenSavings(false);
                    checking.setBalance(0);
                    Account.todayDate = "10000000";
                    bank.setLastDate("10000000");

                    // Creates a random account number for the checking account
                    String accountNumber = CHECKING_PREFIX;
                    for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
                        int num = random.nextInt(10);
                        accountNumber += Integer.toString(num);
                    }
                    checking.setAccountNumber(Integer.parseInt(accountNumber));
                }
            }
        }

        while (!response.equalsIgnoreCase("quit") && !quit) {

            // Below class should have access to username, a variable that it needs to use
            Account accnt = new Account(bank);

            // Asks for today's date if it hasn't already
            if (accnt.todayDate == null || accnt.todayDate.equals("10000000")) {

                // LATER I HAVE TO VALIDATE THAT SOMEONE DOES NOT GO BACK IN TIME
                System.out.printf("%nType in today's date (MMDDYYYY): ");

                // Records the date
                int date;
                do {
                    valid = true;
                    response = input.nextLine();

                    if (response.equalsIgnoreCase("quit")) {
                        break;
                    } else if (response.length() == 8) {

                        // Records the date here (assuming that the format was correct
                        try {
                            date = Integer.parseInt(response); // This confirms that the number is an integer
                            String dateString = Integer.toString(date);

                            // Makes sure that the zero in the beginning is not lost
                            if (dateString.length() == 7) {
                                dateString = ('0' + dateString);
                            }

                            // This makes sure that the date previously used was not in the future of the user's response
                            if (bank.getLastDate() != null && bank.getLastDate().length() == 7) {
                                bank.setLastDate('0' + bank.getLastDate());
                            }

                            if (bank.getLastDate() != null) {

                                // Collects the year, month, and day from user input and user's last input (which
                                // was saved in the file)
                                String lastYear = Character.toString(bank.getLastDate().charAt(4)) +
                                        bank.getLastDate().charAt(5) +
                                        bank.getLastDate().charAt(6) +
                                        bank.getLastDate().charAt(7);
                                String thisYear = Character.toString(dateString.charAt(4)) +
                                        dateString.charAt(5) +
                                        dateString.charAt(6) +
                                        dateString.charAt(7);
                                String lastMonth = Character.toString(bank.getLastDate().charAt(0)) +
                                        bank.getLastDate().charAt(1);
                                String thisMonth = Character.toString(dateString.charAt(0)) +
                                        dateString.charAt(1);
                                String lastDay = Character.toString(bank.getLastDate().charAt(2)) +
                                        bank.getLastDate().charAt(3);
                                String thisDay = Character.toString(dateString.charAt(2)) +
                                        dateString.charAt(3);

                                // The below checks if the user entered a valid date
                                // It makes sure that the new date is not from before the last date
                                // And it makes sure that the current number for the month or days is being applied

                                // Maybe find a way to make sure that the day is correct based on the month if I have time
                                if (Integer.parseInt(thisMonth) > 13 ||
                                        Integer.parseInt(thisMonth) < 1 ||
                                        Integer.parseInt(thisDay) > 31 ||
                                        Integer.parseInt(thisDay) < 1 ||
                                        Integer.parseInt(thisYear) < 1) {
                                    // This checked any invalid dates before the program even tries to process
                                    // if the new date is from the past or not
                                    System.out.printf("%nThis is not a valid date. Please try again: ");
                                } else if (Integer.parseInt(lastYear) < Integer.parseInt(thisYear)) {
                                    accnt.todayDate = dateString;
                                } else {

                                    // Verifies years
                                    if (Integer.parseInt(lastYear) > Integer.parseInt(thisYear)) {
                                        System.out.printf("%nYou cannot choose a date in the past. Please try again: ");
                                        valid = false;

                                        // Verifies months
                                    } else if (Integer.parseInt(lastMonth) < Integer.parseInt(thisMonth)) {
                                        accnt.todayDate = dateString;
                                    } else {
                                        if (Integer.parseInt(lastMonth) > Integer.parseInt(thisMonth)) {
                                            System.out.printf("%nYou cannot choose a date in the past. Please try again: ");
                                            valid = false;

                                            // Verifies days
                                        } else if (Integer.parseInt(lastDay) <= Integer.parseInt(thisDay)) {
                                            accnt.todayDate = dateString;
                                        } else {
                                            System.out.printf("%nYou cannot choose a date in the past. Please try again: ");
                                            valid = false;
                                        }
                                    }
                                }
                            }

                        } catch (NumberFormatException e) {
                            System.out.printf("%nPlease try again. Make sure you are using the correct format (MMDDYYYY): ");
                            valid = false;
                        }
                    } else {
                        System.out.printf("%nPlease try again. Make sure you are using the correct format (MMDDYYYY): ");
                        valid = false;
                    }
                } while (!valid);

                // This section goes through various processes and methods in order to make sure statements and other
                // stuff is being released in a timely manner
                if (bank.getOpenCredit()) {
                    if (credit.getRequest()) {
                        if (credit.checkCreditIncreaseDate()) {
                            String message = (credit.answerCreditLine()) ?
                                    "%nYou have increased your credit line to " + credit.getCreditLine() + ".":
                                    "%nThe bank did not choose to increase your credit line.";
                            System.out.printf(message);
                        }
                    }
                    credit.setStatement(bank.getUsername());
                    if (credit.getStatement() > 0) {
                        // Tells the user to pay their bill
                        System.out.printf("%nYou owe $%,.2f on your credit card. Next bill date is %s." +
                                "%nPay at least $%,.2f.",
                                credit.getStatement(),
                                credit.getBillDate(),
                                credit.getMIN_PAYMENT());
                    }
                }

            }

            if (response.equalsIgnoreCase("quit")) break;



            // Lists accounts to choose from
            System.out.printf("%n%nSelect an account:" +
                    checking);
            if (bank.getOpenSavings()) {
                System.out.print(savings);
            }
            if (bank.getOpenCredit()) {
                System.out.print(credit);
            }

            if (!bank.getOpenSavings()) {
                System.out.printf("%nIf you would like a savings account, type \"open savings\".");
            }
            if (!bank.getOpenCredit()) {
                System.out.printf("%nIf you would like a credit account, type \"open credit\".");
            }

            System.out.println();

            // Collects response
            do {

                valid = true;
                response = input.nextLine();

                // Selects account
                if (response.equalsIgnoreCase("checking")) {
                    System.out.printf("%n%s" +
                                    "%nWould you like to transfer, withdraw, deposit, purchase an item, " +
                                    "or view the logs with this account: ",
                            checking);

                    // This is list of prompts based on what the user chooses
                    String prompt[] = {
                            "How much money would you like to withdraw? (Type \"cancel\" to cancel) ",
                            "How much would you like to deposit? (Type \"cancel\" to cancel) ",
                            "What is the cost of the item(s) that you are purchasing? (Type\"cancel\" to cancel) ",
                            "How much would you like to transfer? (Type \"cancel\" to cancel) "
                    };

                    // This is a list of strings that represents when an action is successfully completed
                    String success[] = {
                            "You have withdrawn ",
                            "You have deposited ",
                            "You have used ",
                            "You have transferred "
                    };

                    Action action = null;
                    int whatPrompt = -1;
                    String symbol = ""; // This is used for formatting when logging, but writing down when amounts are being subtracted or not

                    // Assigns variables based on what the user said so the program can continue accordingly
                    do {

                        valid = true;
                        response = input.nextLine();

                        if (response.equalsIgnoreCase("withdraw")) {
                            action = Action.WITHDRAW;
                            whatPrompt = 0;
                            symbol = "-";
                        } else if (response.equalsIgnoreCase("deposit")) {
                            action = Action.DEPOSIT;
                            whatPrompt = 1;
                            symbol = "+";
                        } else if (response.equalsIgnoreCase("purchase")) {
                            action = Action.PURCHASE;
                            whatPrompt = 2;
                            symbol = "-";
                        } else if (response.equalsIgnoreCase("transfer") &&
                                (bank.getOpenSavings() || bank.getOpenCredit())) {
                            action = Action.TRANSFER;
                            whatPrompt = 3;
                        } else if (response.equalsIgnoreCase("transfer") &&
                                !bank.getOpenSavings() && !bank.getOpenCredit()) {
                            // This is for when someone tries to transfer when their only account is checking
                            valid = false;
                            System.out.printf("%nYou do not have another account to transfer to. Please try again: ");
                        } else if (response.equalsIgnoreCase("logs") ||
                                response.equalsIgnoreCase("log") ||
                                response.equalsIgnoreCase("view the logs") ||
                                response.equalsIgnoreCase("view logs")) {

                            // Asks how many lines should be read
                            System.out.printf("%nHow many lines would you like to be read from the log? ");
                            String number;
                            int num = 0;

                            do {

                                // Gets response
                                valid = true;
                                number = input.nextLine();

                                if (number.equalsIgnoreCase("cancel") ||
                                        number.equalsIgnoreCase("quit")) {
                                    response = number.toLowerCase();
                                    break;
                                } else {
                                    try {

                                        // Parses
                                        num = Integer.parseInt(number);

                                        // Checks if number if valid
                                        if (num <= 0) {
                                            System.out.printf("%nPlease choose a positive number: ");
                                            valid = false;
                                        }

                                        // If parsing fails
                                    } catch (NumberFormatException e) {
                                        System.out.printf("%n%s",
                                                DEFAULT_ERROR);
                                        valid = false;
                                    }

                                }
                            } while (!valid) ;

                            if (number.equalsIgnoreCase("quit") ||
                                    number.equalsIgnoreCase("cancel")) {
                                break;
                            }

                            // Sets up the file to be read
                            File log = new File(bank.getUsername() + "_" + checking.FILENAME + ".txt");
                            FileReader fstream = new FileReader(log);
                            BufferedReader reader = new BufferedReader(fstream);
                            String line;

                            // Displays log
                            for (int i = 0; i < num; i++) {
                                line = reader.readLine();
                                if (line != null) {
                                    System.out.print("\n" + line);
                                } else {
                                    // If user puts a bigger number than the number of existing lines,
                                    // then this will end it
                                    break;
                                }
                            }

                            // Changes response so the rest of the code doesn't run
                            response = "cancel";

                            break;
                        } else if (response.equalsIgnoreCase("quit") ||
                                response.equalsIgnoreCase("cancel")) {
                            break;
                        } else {
                            System.out.printf("%n%s",
                                    DEFAULT_ERROR);
                            valid = false;
                        }

                    } while (!valid);

                    // Asks the user a question based on what they selected
                    if (!(whatPrompt == -1)) {
                        System.out.printf("%n%s",
                                prompt[whatPrompt]);
                    }

                    if (!(response.equalsIgnoreCase("quit") ||
                            response.equalsIgnoreCase("cancel"))) {
                        do {

                            // Records response
                            String amountResponse = input.nextLine();
                            valid = true;
                            double amount;

                            if (amountResponse.equalsIgnoreCase("cancel")) {
                                break;
                            } else if (amountResponse.equalsIgnoreCase("quit")) {
                                response = "quit"; // This helps quit out of the program entirely
                                break;
                            } else {
                                try {

                                    amount = Double.parseDouble(amountResponse);

                                    // If parsing succeeds, this checks if the number parsed is valid
                                    if (amount <= 0) {
                                        System.out.printf("%nPlease input a positive number: ");
                                        valid = false;
                                    } else if (amount > checking.balance &&
                                            (action == Action.WITHDRAW || action == Action.PURCHASE || action == Action.TRANSFER)) {

                                        // If you are taking out money, then you cannot take out more money than you have
                                        System.out.printf("%nYou are trying to %s more than you have: ",
                                                response.toLowerCase());
                                        valid = false;
                                    } else {

                                        // This asks what you are buying when purchasing. This will be recorded in the log
                                        if (action == Action.PURCHASE) {
                                            System.out.printf("%nWhat are you purchasing: ");
                                            String item = input.nextLine();
                                            if (item.equalsIgnoreCase("cancel")) {
                                                break;
                                            } else if (item.equalsIgnoreCase("quit")) {
                                                response = "quit"; // Helps program quit completely
                                                break;
                                            } else {
                                                response += (" " + item);
                                            }

                                        }

                                        // This asks what account the user wants to transfer if the user is transferring
                                        if (action == Action.TRANSFER) {
                                            System.out.printf("%nWhich account are you transferring to: ");
                                            if (bank.getOpenSavings()) {
                                                System.out.printf("%nSavings");
                                            }
                                            if (bank.getOpenCredit()) {
                                                System.out.printf("%nCredit");
                                            }
                                            System.out.print("\n");

                                            do {
                                                valid = true;
                                                String account = input.nextLine();

                                                // Transfers money
                                                if (account.equalsIgnoreCase("savings") && bank.getOpenSavings()) {
                                                    checking.withdraw(amount);
                                                    checking.log(checking.FILENAME,
                                                            accnt.todayDate,
                                                            "Checking",
                                                            "transfer to savings",
                                                            checking.getBalance(),
                                                            amount,
                                                            "-");
                                                    savings.deposit(amount);
                                                    savings.log(savings.FILENAME,
                                                            accnt.todayDate,
                                                            "Savings",
                                                            "transfer from checking",
                                                            savings.getBalance(),
                                                            amount,
                                                            "+");
                                                } else if (account.equalsIgnoreCase("credit") && bank.getOpenCredit()) {

                                                    // Checks if credit needs the transfer
                                                    if (credit.getBalance() - amount < 0) {
                                                        System.out.printf("%nYou credit card cannot take more money than it needs.");
                                                    } else {
                                                        checking.withdraw(amount);
                                                        checking.log(checking.FILENAME,
                                                                accnt.todayDate,
                                                                "Checking",
                                                                "transfer to credit",
                                                                checking.getBalance(),
                                                                amount,
                                                                "-");
                                                        credit.deposit(amount);
                                                        credit.log(credit.FILENAME,
                                                                accnt.todayDate,
                                                                "Credit",
                                                                "transfer from checking",
                                                                credit.getBalance(),
                                                                amount,
                                                                "-");

                                                        // If this is used to pay a bill, this will reset the statement
                                                        // (or lower it, depending on the transfer)
                                                        if (credit.getStatement() > 0) {
                                                            if (amount >= credit.getStatement()) {
                                                                credit.setStatement(0);
                                                                credit.setMinPaymentMet(true);
                                                            } else {
                                                                credit.setStatement(credit.getStatement() - amount);

                                                                // This checks if the minimum payment is met
                                                                // This is important if there is more than one transaction
                                                                // involved
                                                                if (!credit.getMinPaymentMet()) {
                                                                    if (amount >= credit.getMIN_PAYMENT() ||
                                                                            (amount + credit.getAmountPaid()) >= credit.getMIN_PAYMENT()) {
                                                                        credit.setMinPaymentMet(true);
                                                                    } else {
                                                                        credit.setAmountPaid(credit.getAmountPaid() + amount);
                                                                        credit.setMinPaymentMet(false); // Just to make sure
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                } else if (account.equalsIgnoreCase("cancel")) {
                                                    response = "cancel"; // This is needed to make sure that
                                                    // something that shouldn't be printed isn't printed
                                                    break;
                                                } else if (account.equalsIgnoreCase("quit")) {
                                                    response = "quit"; // Helps program quit completely
                                                    break;
                                                } else {
                                                    valid = false;
                                                    System.out.printf("%n%s",
                                                            DEFAULT_ERROR);
                                                }

                                            } while (!valid);

                                        }

                                        // Moves money
                                        if (action == Action.DEPOSIT) {
                                            checking.deposit(amount);
                                        }
                                        if (action == Action.WITHDRAW) {
                                            checking.withdraw(amount);
                                        }
                                        if (action == Action.PURCHASE) {
                                            checking.purchase(amount); // Right now, this has the same effect as withdrawing,
                                            // but in case I want to do something more with this method, I will keep this separate.
                                        }

                                        // Displays what you just did and records it in the log
                                        if (!(response.equalsIgnoreCase("cancel") ||
                                                response.equalsIgnoreCase("quit"))) {
                                            System.out.printf("%n%s%,.2f.%nCurrent Balance: %,.2f",
                                                    success[whatPrompt],
                                                    amount,
                                                    checking.getBalance());
                                        }

                                        if (!(action == Action.TRANSFER)) {
                                            // Transfer log should have already been done at this point so that's why transfers ignore this
                                            checking.log(checking.FILENAME,
                                                    accnt.todayDate,
                                                    "Checking",
                                                    response,
                                                    checking.getBalance(),
                                                    amount,
                                                    symbol);
                                        }
                                    }

                                    // If parsing fails
                                } catch (NumberFormatException e) {
                                    System.out.printf("%n%s",
                                            DEFAULT_ERROR);
                                    valid = false;
                                }

                            }

                        } while (!valid);
                    }


                } else if (response.equalsIgnoreCase("savings") && bank.getOpenSavings()) {
                    System.out.printf("%n%s%nWould you like to transfer, withdraw, deposit, or view the logs from this account account: ",
                            savings); // Add other information later

                    Action action = null; // For helping decipher what action someone is doing
                    int whatPrompt = -1; // For selecting prompt
                    String prompt[] = {
                            "How much money would you like to withdraw? (Type \"cancel\" to cancel) ",
                            "How much money would you like to deposit? (Type \"cancel\" to cancel) ",
                            "How much would you like to transfer? (Type \"cancel\" to cancel) "
                    };
                    double amount; // Records amount of money being transferred

                    String success[] = {
                            "You have withdrawn ",
                            "You have deposited ",
                            "You have transferred "
                    };

                    do {

                        valid = true;
                        response = input.nextLine();

                        if (response.equalsIgnoreCase("withdraw")) {
                            whatPrompt = 0;
                            action = Action.WITHDRAW;
                        } else if (response.equalsIgnoreCase("deposit")) {
                            whatPrompt = 1;
                            action = Action.DEPOSIT;
                        } else if (response.equalsIgnoreCase("transfer")) {
                            whatPrompt = 2;
                            action = Action.TRANSFER;
                        } else if (response.equalsIgnoreCase("logs") ||
                                response.equalsIgnoreCase("log") ||
                                response.equalsIgnoreCase("view the logs") ||
                                response.equalsIgnoreCase("view logs")) {

                            // Asks how many lines should be read
                            System.out.printf("%nHow many lines would you like to be read from the log? ");
                            String number;
                            int num = 0;

                            do {
                                // Gets response
                                valid = true;
                                number = input.nextLine();

                                if (number.equalsIgnoreCase("cancel") ||
                                        number.equalsIgnoreCase("quit")) {
                                    response = number.toLowerCase();
                                    break;
                                } else {
                                    try {

                                        // Parses
                                        num = Integer.parseInt(number);

                                        // Checks if number if valid
                                        if (num <= 0) {
                                            System.out.printf("%nPlease choose a positive number: ");
                                            valid = false;
                                        }

                                        // If parsing fails
                                    } catch (NumberFormatException e) {
                                        System.out.printf("%n%s",
                                                DEFAULT_ERROR);
                                        valid = false;
                                    }
                                }
                            } while (!valid) ;

                            // Sets up the file to be read
                            File log = new File(bank.getUsername() + "_" + savings.FILENAME + ".txt");
                            FileReader fstream = new FileReader(log);
                            BufferedReader reader = new BufferedReader(fstream);
                            String line;

                            // Displays log
                            for (int i = 0; i < num; i++) {
                                line = reader.readLine();
                                if (line != null) {
                                    System.out.print("\n" + line);
                                } else {
                                    // If user puts a bigger number than the number of existing lines,
                                    // then this will end it
                                    break;
                                }
                            }

                            // Changes response so the rest of the code doesn't run
                            response = "cancel";

                            break;
                        } else if (response.equalsIgnoreCase("quit") ||
                                response.equalsIgnoreCase("cancel")) {
                            break;
                        } else {
                            valid = false;
                            System.out.printf("%n%s",
                                    DEFAULT_ERROR);
                        }

                    } while (!valid);

                    if (response.equalsIgnoreCase("quit") ||
                            response.equalsIgnoreCase("cancel")) {
                        break;
                    } else {

                        System.out.printf("%n%s",
                                prompt[whatPrompt]);

                        do {

                            valid = true;

                            String stringAmount = input.nextLine();

                            if (stringAmount.equalsIgnoreCase("cancel") ||
                                    stringAmount.equalsIgnoreCase("quit")) {
                                response = stringAmount.toLowerCase(); // To help with continuing the program properly
                                break;
                            } else {
                                try {

                                    amount = Double.parseDouble(stringAmount);

                                    if (amount <= 0) {
                                        System.out.printf("%nPlease input a positive number: ");
                                        valid = false;
                                    } else if (amount > savings.getBalance() &&
                                            (action == Action.WITHDRAW || action == Action.TRANSFER)) {
                                        System.out.printf("%nYou cannot %s more than you have. Please try again: ",
                                                response.toLowerCase());
                                        valid = false;
                                    } else {

                                        if (action == Action.TRANSFER) {

                                            System.out.printf("%nWhich account are you transferring to: %nChecking%n");
                                            if (bank.getOpenCredit()) {
                                                System.out.printf("Credit%n");
                                            }

                                            do {

                                                valid = true;
                                                String account = input.nextLine();

                                                // Transfers money
                                                if (account.equalsIgnoreCase("checking")) {
                                                    savings.withdraw(amount);
                                                    savings.log(savings.FILENAME,
                                                            accnt.todayDate,
                                                            "Savings",
                                                            "transfer",
                                                            savings.getBalance(),
                                                            amount,
                                                            "-");
                                                    checking.deposit(amount);
                                                    checking.log(checking.FILENAME,
                                                            accnt.todayDate,
                                                            "Checking",
                                                            "transfer",
                                                            checking.getBalance(),
                                                            amount,
                                                            "+");

                                                    // Transfers to credit
                                                } else if (account.equalsIgnoreCase("credit") && bank.getOpenCredit()) {
                                                    savings.withdraw(amount);
                                                    savings.log(savings.FILENAME,
                                                            accnt.todayDate,
                                                            "Savings",
                                                            "transfer",
                                                            savings.getBalance(),
                                                            amount,
                                                            "-");
                                                    credit.deposit(amount);
                                                    credit.log(credit.FILENAME,
                                                            accnt.todayDate,
                                                            "Credit",
                                                            "transfer",
                                                            credit.getBalance(),
                                                            amount,
                                                            "-");

                                                    // If this is used to pay a bill, this will reset the statement
                                                    // (or lower it, depending on the transfer)
                                                    if (credit.getStatement() > 0) {
                                                        if (amount >= credit.getStatement()) {
                                                            credit.setStatement(0);

                                                            // Updates credit score
                                                            if (credit.getMinPaymentMet()) {
                                                                credit.addCreditScore(.5);
                                                            } else {
                                                                credit.addCreditScore(1);
                                                            }

                                                            credit.setMinPaymentMet(true);
                                                        } else {
                                                            credit.setStatement(credit.getStatement() - amount);

                                                            // This checks if the minimum payment is met
                                                            // This is important if there is more than one transaction
                                                            // involved
                                                            if (!credit.getMinPaymentMet()){
                                                                if (amount >= credit.getMIN_PAYMENT() ||
                                                                        (amount + credit.getAmountPaid()) >= credit.getMIN_PAYMENT()) {
                                                                    credit.setMinPaymentMet(true);
                                                                    credit.addCreditScore(.5);
                                                                } else {
                                                                    credit.setAmountPaid(credit.getAmountPaid() + amount);
                                                                    credit.setMinPaymentMet(false); // Just to make sure
                                                                }
                                                            }
                                                        }
                                                    }

                                                } else if (account.equalsIgnoreCase("cancel")) {
                                                    break;
                                                } else if (account.equalsIgnoreCase("quit")) {
                                                    response = "quit"; // Helps program completely quit
                                                    break;
                                                } else {
                                                    System.out.printf("%n%s",
                                                            DEFAULT_ERROR);
                                                    valid = false;
                                                }


                                            } while (!valid);

                                        }

                                        // Variable for logging purposes
                                        String symbol = " ";

                                        // Withdraws or deposits based on response
                                        if (action == Action.WITHDRAW) {
                                            savings.withdraw(amount);
                                            symbol = "-";
                                        } else if (action == Action.DEPOSIT) {
                                            savings.deposit(amount);
                                            symbol = "+";
                                        }

                                        // Displays what happened
                                        System.out.printf("%n%s%,.2f.",
                                                success[whatPrompt],
                                                amount);

                                        // Logs
                                        if (!(action == Action.TRANSFER)) {
                                            savings.log(savings.FILENAME,
                                                    accnt.todayDate,
                                                    "Savings",
                                                    response,
                                                    savings.getBalance(),
                                                    amount,
                                                    symbol);
                                        }

                                    }

                                    // If parsing fails
                                } catch (NumberFormatException e) {
                                    System.out.printf("%n%s",
                                            DEFAULT_ERROR);
                                    valid = false;
                                }
                            }

                        } while (!valid);

                    }

                } else if (response.equalsIgnoreCase("credit") && bank.getOpenCredit()) {

                    // Lists options
                    System.out.printf("%n%s%nWould you like to purchase an item with this account: " +
                            "%nOr, type \"more\" instead for more options: ",
                            credit); // Add other information later

                    do {

                        // Records response
                        valid = true;
                        response = input.nextLine();

                        // If yes, goes through the prompts to get the amount of the purchase and what item
                        if (response.equalsIgnoreCase("y") ||
                                response.equalsIgnoreCase("yes") ||
                                response.equalsIgnoreCase("purchase")) {

                            // In case you try to purchase something when over credit
                            if (credit.getBalance() >= credit.getCreditLine()) {
                                System.out.printf("%nYou do not have enough credit to make any purchase.");
                                break;
                            } else {

                                // Asks for cost of items
                                System.out.printf("%nHow much does the item(s) cost? (Type \"cancel\" anytime to cancel) ");

                                do {

                                    // Records input
                                    valid = true;
                                    String stringAmount = input.nextLine();

                                    // If cancelled
                                    if (stringAmount.equalsIgnoreCase("cancel")) {
                                        break;
                                    } else if (stringAmount.equalsIgnoreCase("quit")) {
                                        response = "quit"; // Helps program quit completely
                                        break;
                                    } else {
                                        try {

                                            // Tries to parse string if it is a number. Loops back if it isn't
                                            double amount = Double.parseDouble(stringAmount);

                                            // Goes through various test to make sure that the number inputted by user
                                            // was valid
                                            if (amount < 0) {
                                                System.out.printf("%nPlease input a positive number: ");
                                                valid = false;
                                            } else if (amount > (credit.getCreditLine() - credit.getBalance())) {
                                                System.out.printf("%nYou do not have enough credit for this purchase: ");
                                                valid = false;
                                            } else {

                                                // If valid, then asks for the name of the item
                                                System.out.printf("%nWhat is the name of the item purchased: ");

                                                do {

                                                    valid = true;
                                                    String item = input.nextLine();

                                                    if (item.equalsIgnoreCase("cancel") ||
                                                            item.equalsIgnoreCase("quit")) {
                                                        break;
                                                    } else {

                                                        // Records the item, takes the money out of the account,
                                                        // logs it, then displays it
                                                        response += (" " + item);
                                                        credit.purchase(amount);
                                                        credit.log(credit.FILENAME,
                                                                accnt.todayDate,
                                                                "Credit",
                                                                response,
                                                                credit.getBalance(),
                                                                amount,
                                                                "+");
                                                        System.out.printf("%nYou have used %,.2f",
                                                                amount);
                                                    }

                                                } while (!valid);


                                            }

                                            // If parsing fails
                                        } catch (NumberFormatException e) {
                                            System.out.printf("%n%s",
                                                    DEFAULT_ERROR);
                                            valid = false;
                                        }
                                    }

                                } while (!valid);

                            }

                        } else if (response.equalsIgnoreCase("more")) {

                            // Asks options
                            System.out.printf("Would you like to do the the following? Type \"cancel\" to go back." +
                                    "%nReview statement" +
                                    "%nRequest credit line increase" +
                                    "%nClaim rewards" +
                                    "%nView the logs%n");

                            do {

                                valid = true;
                                response = input.nextLine();

                                if (response.equalsIgnoreCase("review") ||
                                        response.equalsIgnoreCase("review statement")) {

                                    // Reviews statement
                                    System.out.printf("%nYour statement is %,.2f." +
                                            "%nThe next statement date is %s",
                                            credit.getStatement(),
                                            credit.getBillDate());
                                    if (!credit.getMinPaymentMet()) {
                                        System.out.printf("%The minimum payment due is %,.2f" +
                                                "%nYou still owe %,.2f",
                                                credit.getMIN_PAYMENT(),
                                                (credit.getMIN_PAYMENT() - credit.getAmountPaid()));
                                    }

                                } else if (response.equalsIgnoreCase("request") ||
                                        response.equalsIgnoreCase("request credit") ||
                                        response.equalsIgnoreCase("request credit line") ||
                                        response.equalsIgnoreCase("request credit line increase") ||
                                        response.equalsIgnoreCase("credit line" ) ||
                                        response.equalsIgnoreCase("credit") ||
                                        response.equalsIgnoreCase("credit line increase")) {

                                    // Requests credit line increase

                                    // Checks if a credit line increase was already requested
                                    if (credit.getRequest()) {
                                        System.out.printf("%nYou have already requested a credit line increase for ,.",
                                                credit.getRequestLine());
                                    } else {

                                        // Asks how much the user wants to increase their
                                        System.out.printf("%nWhat is the credit line that you would like? ");

                                        // Gets the credit line from user
                                        do {

                                            valid = true;
                                            String requestLine = input.nextLine();
                                            double request;

                                            if (requestLine.equalsIgnoreCase("cancel")) {
                                                break;
                                            } else if (requestLine.equalsIgnoreCase("quit")) {
                                                response = "quit"; // Helps program completely quit
                                                break;
                                            } else {
                                                try {

                                                    request = Double.parseDouble(requestLine);

                                                    if (request < credit.getCreditLine()) {
                                                        System.out.printf(", is less than you current credit line (%,.2f)." +
                                                                        "%nPlease try again: ",
                                                                request,
                                                                credit.getCreditLine());
                                                        valid = false;
                                                    } else {

                                                        // Sets up the request
                                                        credit.setRequestLine(request);
                                                        credit.setRequest(true);
                                                        credit.setCreditIncreaseDate(accnt.todayDate);
                                                        // Do I need anything else?

                                                        // Success message
                                                        System.out.printf("%nThe request is successfully submitted." +
                                                                "%nPlease wait three days for the request to process.");

                                                    }

                                                } catch (NumberFormatException e) {
                                                    // If parsing fails
                                                    System.out.printf("%n%s",
                                                            DEFAULT_ERROR);
                                                    valid = false;
                                                }
                                            }

                                        } while (!valid);

                                    }

                                } else if (response.equalsIgnoreCase("claim") ||
                                        response.equalsIgnoreCase("claim rewards") ||
                                        response.equalsIgnoreCase("rewards")) {

                                    if (credit.getRewards() == 0) {

                                        // Checks if there are any rewards to claim in the first place
                                        System.out.printf("%nThere are no rewards to claim.");
                                    } else {

                                        // Claims rewards
                                        if (bank.getOpenSavings()) {

                                            // Asks user to pick an account if they ahve a savings account set up
                                            System.out.printf("%nWhich account would you like to transfer the money to: " +
                                                    "%nChecking" +
                                                    "%nSavings%n");

                                            String account; // Keeps track of account transferred to
                                            do {

                                                valid = true;
                                                account = input.nextLine();

                                                if (account.equalsIgnoreCase("checking")) {

                                                    // Transfers money to checking account
                                                    System.out.printf("%nYou have transferred $%,.2f to your checking account.",
                                                            credit.getRewards());
                                                    checking.deposit(credit.getRewards());
                                                    checking.log(checking.FILENAME,
                                                            accnt.todayDate,
                                                            "Checking",
                                                            "Credit Rewards",
                                                            checking.getBalance(),
                                                            credit.getRewards(),
                                                            "+");
                                                    credit.setRewards(0.0);

                                                } else if (account.equalsIgnoreCase("savings")) {

                                                    // Transfers money to savings account
                                                    System.out.printf("%nYou have transferred $%,.2f to your savings account.",
                                                            credit.getRewards());
                                                    savings.deposit(credit.getRewards());
                                                    savings.log(savings.FILENAME,
                                                            accnt.todayDate,
                                                            "Savings",
                                                            "Credit Rewards",
                                                            savings.getBalance(),
                                                            credit.getRewards(),
                                                            "+");
                                                    credit.setRewards(0.0);

                                                } else if (account.equalsIgnoreCase("cancel")) {
                                                    break;
                                                } else if (account.equalsIgnoreCase("quit")) {
                                                    response = "quit"; // Helps program quit
                                                    break;
                                                } else {
                                                    System.out.printf("%n%s",
                                                            DEFAULT_ERROR);
                                                    valid = false;
                                                }

                                            } while (!valid);

                                        } else {

                                            // If they only have a checking account, then the money is
                                            // automatically transferred there
                                            System.out.printf("%nYou have transferred $%,.2f to your checking account.",
                                                    credit.getRewards());
                                            checking.deposit(credit.getRewards());
                                            checking.log(checking.FILENAME,
                                                    accnt.todayDate,
                                                    "Checking",
                                                    "Credit Rewards",
                                                    checking.getBalance(),
                                                    credit.getRewards(),
                                                    "+");
                                            credit.setRewards(0.0);
                                        }
                                    }

                                } else if (response.equalsIgnoreCase("logs") ||
                                        response.equalsIgnoreCase("log") ||
                                        response.equalsIgnoreCase("view the logs") ||
                                        response.equalsIgnoreCase("view logs")) {

                                    // Asks how many lines should be read
                                    System.out.printf("%nHow many lines would you like to be read from the log? ");
                                    String number;
                                    int num = 0;
                                    do {

                                        // Gets response
                                        valid = true;
                                        number = input.nextLine();

                                        if (number.equalsIgnoreCase("cancel") ||
                                            number.equalsIgnoreCase("quit")) {
                                            response = number.toLowerCase();
                                            break;
                                        } else {

                                            try {

                                                // Parses
                                                num = Integer.parseInt(number);

                                                // Checks if number if valid
                                                if (num <= 0) {
                                                    System.out.printf("%nPlease choose a positive number: ");
                                                    valid = false;
                                                }

                                                // If parsing fails
                                            } catch (NumberFormatException e) {
                                                System.out.printf("%n%s",
                                                        DEFAULT_ERROR);
                                                valid = false;
                                            }
                                        }

                                    } while (!valid) ;

                                    // Sets up the file to be read
                                    File log = new File(bank.getUsername() + "_" + credit.FILENAME + ".txt");
                                    FileReader fstream = new FileReader(log);
                                    BufferedReader reader = new BufferedReader(fstream);
                                    String line;

                                    // Displays log
                                    for (int i = 0; i < num; i++) {
                                        line = reader.readLine();
                                        if (line != null) {
                                            System.out.print("\n" + line);
                                        } else {
                                            // If user puts a bigger number than the number of existing lines,
                                            // then this will end it
                                            break;
                                        }
                                    }
                                    break;

                                } else if (response.equalsIgnoreCase("quit") ||
                                        response.equalsIgnoreCase("cancel")) {
                                    break;
                                } else {
                                    System.out.printf("%n%s",
                                            DEFAULT_ERROR);
                                    valid = false;
                                }

                            } while (!valid);

                        } else if (response.equalsIgnoreCase("n") ||
                                response.equalsIgnoreCase("no") ||
                                response.equalsIgnoreCase("quit") ||
                                response.equalsIgnoreCase("cancel")) {
                            break;
                        } else {
                            System.out.printf("%n%s",
                                    DEFAULT_ERROR);
                            valid = false;
                        }

                    } while (!valid);

                    // Make new accounts
                } else if (response.equalsIgnoreCase("open savings") && !bank.getOpenSavings()) {

                    // Initiates default variables
                    bank.setOpenSavings(true);
                    String accountNumber = SAVINGS_PREFIX;
                    for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
                        int num = random.nextInt(10);
                        accountNumber += Integer.toString(num);
                    }
                    savings.setAccountNumber(Integer.parseInt(accountNumber));
                    savings.setBalance(0);
                    savings.setDate(accnt.todayDate);

                    // Displays information
                    System.out.printf("%nYou have opened up a savings account." +
                                    "%nIt has an interest rate of %,.2f%% per month and currently a balance of $%,.2f.",
                            savings.getInterest(),
                            savings.getBalance());

                    // Logs the fact that an account opened
                    savings.log(savings.FILENAME,
                            accnt.todayDate,
                            "Savings",
                            "opened",
                            savings.getBalance(),
                            0,
                            " ");

                } else if (response.equalsIgnoreCase("open credit") && !bank.getOpenCredit()) {

                    // Initiates variables
                    bank.setOpenCredit(true);
                    // Account Number
                    String accountNumber = CREDIT_PREFIX;
                    for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
                        int num = random.nextInt(10);
                        accountNumber += Integer.toString(num);
                    }
                    credit.setAccountNumber(Integer.parseInt(accountNumber));
                    credit.setBalance(0);
                    credit.setDate(accnt.todayDate);
                    credit.setStartingDate(accnt.todayDate);
                    credit.setCreditLine(1000.00);
                    credit.setRewardRate(.02);
                    // Bill date
                    if (Integer.parseInt(accnt.todayDate) + 1000000 > 13000000) {
                        // Accounts for when the month is December
                        credit.setBillDate('0' + Integer.toString(Integer.parseInt(accnt.todayDate) - 11000000));

                    } else {
                        String billDate;
                        billDate = Integer.toString(Integer.parseInt(accnt.todayDate) + 1000000);
                        if (billDate.length() == 7) {
                            billDate = '0' + billDate; // I want to keep the zero in front
                        }
                        credit.setBillDate(billDate);
                    }

                    // Displays the information
                    System.out.printf("%nYou have opened up a credit account." +
                            "%nThe credit line is $%,.2f." + "%nStatement will be released %s." +
                            "%nYou will get %,.2f%% rewards per purchase which you can redeem when the statement is processed.",
                            credit.getCreditLine(),
                            credit.getBillDate(),
                            credit.getRewardRate() * 100);

                    // Logs the opened account
                    credit.log(credit.FILENAME,
                            accnt.todayDate,
                            "Credit",
                            "opened",
                            credit.getBalance(),
                            0,
                            " ");

                } else if (response.equalsIgnoreCase("quit")) {
                    break;
                } else {
                    System.out.printf("%n%s",
                            DEFAULT_ERROR);
                }

            } while (!valid);
        }

        // Quit message
        try {
            if (bank.getUsername().equalsIgnoreCase("quit") ||
                    bank.getPassword().equalsIgnoreCase("quit") ||
                    response.equalsIgnoreCase("quit")) {
                System.out.printf("%nYou have quit.");

                // Saves content
                saveFile(bank.getUsername(),
                        bank.getPassword(),
                        bank.getOpenSavings(),
                        bank.getOpenCredit(),
                        checking.getBalance(),
                        checking.getAccountNumber(),
                        savings.getBalance(),
                        savings.getAccountNumber(),
                        savings.getDate(),
                        credit.getBalance(),
                        credit.getAccountNumber(),
                        credit.getDate(),
                        credit.getStartingDate(),
                        credit.getCreditLine(),
                        credit.getCreditIncreaseDate(),
                        credit.getRequest(),
                        credit.getRequestLine(),
                        credit.getRewards(),
                        credit.getRewardRate(),
                        credit.getStatement(),
                        credit.getAmountPaid(),
                        credit.getMinPaymentMet(),
                        credit.getBillDate(),
                        credit.getCreditScore(),
                        Account.todayDate);

            }
        } catch (NullPointerException e) {
            System.out.printf("%nYou have quit.");
        }

        // Loop so when you create a new account you can automatically use it

    }

    public static void saveFile(String username,
                                String password,
                                boolean openSavings,
                                boolean openCredit,
                                double checkingBalance,
                                int checkingAccountNumber,
                                double savingsBalance,
                                int savingsAccountNumber,
                                String savingsDate,
                                double creditBalance,
                                int creditAccountNumber,
                                String creditDate,
                                String creditStartingDate,
                                Double creditLine,
                                String creditIncreaseDate,
                                Boolean creditRequest,
                                Double creditRequestLine,
                                Double creditRewards,
                                Double creditRewardRate,
                                Double creditStatement,
                                Double creditAmountPaid,
                                Boolean creditMinPaymentMet,
                                String creditBillDate,
                                double creditScore,
                                String todayDate) {
        File saveFile = new File(username + ".txt");
        try {
            FileWriter fstream = new FileWriter(saveFile, false);
            String encryptedUsername = encrypt(username, true);
            fstream.write(encryptedUsername + "\n");
            String encryptedPassword = encrypt(password, true);
            fstream.write(encryptedPassword + "\n");
            String encryptedOpenSavings = encryptBoolean(openSavings);
            fstream.write(encryptedOpenSavings + "\n");
            String encryptedOpenCredit = encryptBoolean(openCredit);
            fstream.write(encryptedOpenCredit + "\n");
            String encryptedCheckingBalance = encrypt(Double.toString(checkingBalance), true);
            fstream.write(encryptedCheckingBalance + "\n");
            String encryptedCheckingAccountNumber = encrypt(Integer.toString(checkingAccountNumber), true);
            fstream.write(encryptedCheckingAccountNumber + "\n");
            if (openSavings) {
                String encryptedSavingsBalance = encrypt(Double.toString(savingsBalance), true);
                fstream.write(encryptedSavingsBalance + "\n");
                String encryptedSavingsAccountNumber = encrypt(Integer.toString(savingsAccountNumber), true);
                fstream.write(encryptedSavingsAccountNumber + "\n");
                String encryptedSavingsDate = encrypt(savingsDate, true);
                fstream.write(encryptedSavingsDate + "\n");
            }
            if (openCredit) {
                String encryptedCreditBalance = encrypt(Double.toString(creditBalance), true);
                fstream.write(encryptedCreditBalance + "\n");
                String encryptedCreditAccountNumber = encrypt(Integer.toString(creditAccountNumber), true);
                fstream.write(encryptedCreditAccountNumber + "\n");
                String encryptedCreditDate = encrypt(creditDate, true);
                fstream.write(encryptedCreditDate + "\n");
                String encryptedCreditStartingDate = encrypt(creditStartingDate, true);
                fstream.write(encryptedCreditStartingDate + "\n");
                String encryptedCreditLine = encrypt(Double.toString(creditLine), true);
                fstream.write(encryptedCreditLine + "\n");
                String encryptedCreditIncreaseDate = encrypt(creditIncreaseDate, true);
                fstream.write(encryptedCreditIncreaseDate + "\n");
                String encryptedCreditRequest = encryptBoolean(creditRequest);
                fstream.write(encryptedCreditRequest + "\n");
                String encryptedRequestLine = encrypt(Double.toString(creditRequestLine), true);
                fstream.write(encryptedRequestLine + "\n");
                String encryptedCreditRewards = encrypt(Double.toString(creditRewards), true);
                fstream.write(encryptedCreditRewards + "\n");
                String encryptedCreditRewardRate = encrypt(Double.toString(creditRewardRate), true);
                fstream.write(encryptedCreditRewardRate + "\n");
                String encryptedCreditStatement = encrypt(Double.toString(creditStatement), true);
                fstream.write(encryptedCreditStatement + "\n");
                String encryptedCreditAmountPaid = encrypt(Double.toString(creditAmountPaid), true);
                fstream.write(encryptedCreditAmountPaid + "\n");
                String encryptedCreditMinPaymentMet = encryptBoolean(creditMinPaymentMet);
                fstream.write(encryptedCreditMinPaymentMet + "\n");
                String encryptedCreditBillDate = encrypt(creditBillDate, true);
                fstream.write(encryptedCreditBillDate + "\n");
                String encryptedCreditScore = encrypt(Double.toString(creditScore), true);
                fstream.write(encryptedCreditScore + "\n");
            }
            String encryptedTodayDate = encrypt(todayDate, true);
            fstream.write(encryptedTodayDate + "\n");

            fstream.close();
        } catch (Exception e) {
            System.out.print("\nError: " + e.getMessage());
        }
    }

    // Changes the characters for each string in order to get an unreadable line.
    // encrypt argument decides whether to encrypt or decrypt
    public static String encrypt(String string, boolean encrypt) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            int num;
            if (i % 5 == 0) {
                num = (i+1) * 2;
            } else if (i % 3 == 0) {
                num = (i+2) * 3;
            } else if (i % 2 == 0) {
                num = 4;
            } else {
                num = i * 2;
            }

            if (encrypt) {
                newString += (char) (string.charAt(i) - num);
            } else newString += (char) (string.charAt(i) + num);

        }
        return newString;
    }

    // Encrypts booleans
    public static String encryptBoolean(boolean value) {
        Random random = new Random();
        String newString = "";
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char theLetter;
        boolean hasLetter = false;
        if (value) {
            theLetter = 't';
        } else {
            theLetter = 'f';
        }
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(characters.length());

            char letter = characters.charAt(num);

            // To figure out if this is true or false, the true ones will have the letter 't', while false ones
            // will have a letter 'f'
            // If true
            if (value) {
                if (letter == theLetter) {
                    hasLetter = true;
                    newString += letter;
                } else if (letter == 'f') { // Makes sure that the opposite letter doesn't mess with it
                    continue;
                } else newString += letter;

                // If false
            } else {
                if (letter == theLetter)  {
                    hasLetter = true;
                    newString += letter;
                } else if (letter == 't') { // Makes sure that the opposite letter doesn't mess with it
                    continue;
                } else newString += letter;
            }

            if (i == 9 && !hasLetter) newString += theLetter;

        }

        return newString;
    }

    // Decrypts booleans. The string has a letter 't' if it is true or a letter 'f' if it is false
    public static boolean decryptBoolean(String value) throws Exception {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == 'f') {
                return false;
            } else if (value.charAt(i) == 't') {
                return true;
            }
        }

        // Encryption failed if it reaches here
        throw new Exception("No boolean to return: " + value);

    }

}
