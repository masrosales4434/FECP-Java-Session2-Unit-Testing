package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        int menuChoice;


        do{
            System.out.println("=====The Blue Bank=====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter option:");
            menuChoice = input.nextInt();
            input.nextLine();

            switch(menuChoice){
                case 1:
                    System.out.print("Enter Account Number: ");
                    int inputAccNumber = input.nextInt();
                    input.nextLine();

                    boolean accountExists = false;

                    for(BankAccount b : listOfBankAccounts){
                        if (inputAccNumber == b.getAccountNumber()){
                            System.out.println("Account Number already exists.");
                            accountExists = true;
                            break;
                        }
                    }
                    if(!accountExists){
                        System.out.print("Enter Account Name: ");
                        String inputAccName = input.nextLine();

                        int withInitialDeposit = 0;
                        do{
                            System.out.println("Do you want to make an initial deposit (1 if yes | 0 if no)?");
                            withInitialDeposit = input.nextInt();
                        }while (withInitialDeposit <0 || withInitialDeposit >1);

                        if(withInitialDeposit == 1){
                            System.out.print("Enter initial deposit: ");
                            double inputInitialDeposit = input.nextDouble();
                            try{
                                listOfBankAccounts.add(new BankAccount(inputAccNumber,inputAccName,inputInitialDeposit));
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                                break;
                            }
                        }else{
                            listOfBankAccounts.add(new BankAccount(inputAccNumber,inputAccName));
                            break;
                        }

                    }
                    break;

                case 2:
                    for (BankAccount b : listOfBankAccounts){
                        b.displayInformation();
                    }
                    break;

                case 3:
                    System.out.print("Enter bank account number: ");
                    int inputBankAccNum = input.nextInt();
                    input.nextLine();

                    boolean accountFound = false;
                    for(BankAccount b : listOfBankAccounts){
                        if (b.getAccountNumber() == inputBankAccNum){
                            System.out.println("Current balance: "+b.getAvailableBalance());
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound){
                        System.out.println("Account Number not found.");
                        break;
                    }
                    break;

                case 4:
                    System.out.print("Enter bank account number to deposit to: ");
                    int inputBankAccNumDeposit = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter amount to deposit: ");
                    double inputAmountToDeposit = input.nextDouble();
                    input.nextLine();
                    boolean accountFoundDeposit = false;
                    for(BankAccount b : listOfBankAccounts){
                        if (b.getAccountNumber() == inputBankAccNumDeposit){
                            System.out.println(b.deposit(inputAmountToDeposit));
                            accountFoundDeposit = true;
                            break;
                        }
                    }
                    if (!accountFoundDeposit){
                        System.out.println("Account Number not found.");
                        break;
                    }
                    break;
                case 5:
                    System.out.print("Enter bank account number to withdraw from: ");
                    int inputBankAccNumWithdraw = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter amount to withdraw: ");
                    double inputAmountToWithdraw = input.nextDouble();
                    input.nextLine();
                    boolean accountFoundWithdraw = false;
                    for(BankAccount b : listOfBankAccounts){
                        if (b.getAccountNumber() == inputBankAccNumWithdraw){
                            System.out.println(b.withdraw(inputAmountToWithdraw));
                            accountFoundWithdraw = true;
                            break;
                        }
                    }
                    if (!accountFoundWithdraw){
                        System.out.println("Account Number not found.");
                        break;
                    }
                    break;
            }


        }while(menuChoice != 6);

        System.out.println("Thank you!");
    }
}