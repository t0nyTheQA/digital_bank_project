package ui.Models;

public class NewCheckingData {
    private String accountName;
    private String accountType;
    private String ownership;
    private double deposit;

    public NewCheckingData(String accountName, String accountType, String ownership, double deposit) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.ownership = ownership;
        this.deposit = deposit;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
