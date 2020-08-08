package Application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input;

        try {
            input = new Scanner(System.in);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer accountNumber = input.nextInt();

            System.out.print("Holder: ");
            String accountHolder = input.nextLine();

            input.nextLine();

            System.out.print("Initial balance: ");
            Double accountBalance = input.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = input.nextDouble();

            Account account = new Account(
                    accountNumber,
                    accountHolder,
                    accountBalance,
                    withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            Double withdrawAmount = input.nextDouble();

            account.withdraw(withdrawAmount);
            System.out.println("New balance: " + account.getAccountBalance());

        } catch (DomainException error) {
            System.out.println("Withdraw error: " + error.getMessage());

        }



    }


}
