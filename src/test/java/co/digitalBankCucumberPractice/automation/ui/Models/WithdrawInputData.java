package co.digitalBankCucumberPractice.automation.ui.Models;

public class WithdrawInputData {

    private String accountName;
    private String withdrawAmount;

    public WithdrawInputData(String accountName, String withdrawAmount) {
        this.accountName = accountName;
        this.withdrawAmount = withdrawAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(String withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
