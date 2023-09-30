package co.digitalBankCucumberPractice.automation.ui.steps.DataTableTransformer;

import co.digitalBankCucumberPractice.automation.ui.Models.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.it.Data;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public CheckingAccountCard checkingAccountCardEntry(Map<String, String> entry) {

        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.parseLong(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate");
        double balance = Double.parseDouble(entry.get("balance"));


        return new CheckingAccountCard(accountName, accountType, ownership, accountNumber, interestRate, balance);
    }


    @DataTableType
    public CheckingTransactionMenu checkingTransactionMenuEntry(Map<String, String> entry) {
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));

        return new CheckingTransactionMenu(date, category, description, amount, balance);
    }

    @DataTableType
    public NewCheckingData newCheckingData(Map<String, String> entry) {
        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        double deposit = Double.parseDouble(entry.get("deposit"));

        return new NewCheckingData(accountName, accountType, ownership, deposit);
    }

    @DataTableType
    public RegistrationData registrationData(Map<String, String> entry) {

        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        String dateOfBirth = entry.get("dateOfBirth");
        String ssn = entry.get("ssn");
        String email = entry.get("email");
        String password = entry.get("password");
        String confirmPassword = entry.get("confirmPassword");
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String mobilePhone = entry.get("mobilePhone");

        return new RegistrationData(title, firstName, lastName, gender,
                dateOfBirth, ssn, email, password, confirmPassword,
                address, locality, region, postalCode, country, mobilePhone);
    }
    @DataTableType
    public NewSavingAccountData newSavingAccountData(Map<String, String> entry) {

        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        String accountName = entry.get("accountName");
        double initialDeposit = Double.parseDouble(entry.get("initialDeposit"));

        return new NewSavingAccountData(accountType, ownership, accountName, initialDeposit);
    }

    @DataTableType
    public SavingAccountCard savingAccountCard(Map<String, String> entry){

         String accountName = entry.get("accountName");
         String accountType = entry.get("accountType");
         String ownership = entry.get("ownership");
         String accountNumber= entry.get("accountNumber");
         double interestRate =Double.parseDouble(entry.get("interestRate"));
         double balance = Double.parseDouble(entry.get("balance"));

        return new SavingAccountCard(accountName,accountType,ownership, accountNumber, interestRate, balance);
    }


    @DataTableType
    public WithdrawInputData withdrawInputData(Map<String, String> entry){
         String accountName = entry.get("accountName");
         String withdrawAmount = entry.get("withdrawAmount");

        return new WithdrawInputData(accountName, withdrawAmount);
    }



}