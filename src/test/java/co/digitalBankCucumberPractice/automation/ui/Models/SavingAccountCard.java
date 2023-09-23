package co.digitalBankCucumberPractice.automation.ui.Models;

public class SavingAccountCard {

    private String accountName;
    private String accountType;
    private String ownership;
    private String accountNumber;
    private double interestRate;
    private double balance;

    public SavingAccountCard(String accountName, String accountType, String ownership, String accountNumber, double interestRate, double balance) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.ownership = ownership;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.balance = balance;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
