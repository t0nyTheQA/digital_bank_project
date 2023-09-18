package co.digitalBankCucumberPractice.automation.ui.Models;

public class NewSavingAccountData {

    private String accountType;
    private String ownership;
    private String accountName;
    private double initialDeposit;

    public NewSavingAccountData(String accountType, String ownership, String accountName, double initialDeposit) {
        this.accountType = accountType;
        this.ownership = ownership;
        this.accountName = accountName;
        this.initialDeposit = initialDeposit;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
