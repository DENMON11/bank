public class Bank {

    private String username, password, lastDate;
    private boolean openSavings = false, openCredit = false;

    // Setters and getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getOpenSavings() {
        return openSavings;
    }

    public void setOpenSavings(boolean open) {
        openSavings = open;
    }

    public boolean getOpenCredit() {
        return openCredit;
    }

    public void setOpenCredit(boolean open) {
        openCredit = open;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }



    // Constructor
    public Bank() {

    }

    @Override
    public String toString() {
        return username;
    }

}
