package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount b;

    @Test
    void returnsCorrectAmountWithValidDeposit() {
        b = new BankAccount(111,"marvin");
        b.displayInformation();

        b.deposit(200.0);
        double actual = b.getAvailableBalance();
        b.displayInformation();

        assertEquals(200.0,actual);
    }

    @Test
    void returnsErrorWithInvalidDeposit(){
        b = new BankAccount(111,"marvin");
        String actual = b.deposit(-100.0);

        assertEquals("Invalid deposit amount.", actual);
    }

    @Test
    void returnsCorrectAmountWithValidWithdraw(){
        b = new BankAccount(111,"marvin");

        b.deposit(200.0);
        b.withdraw(100.0);
        double actual = b.getAvailableBalance();

        assertEquals(100.0,actual);
    }

    @Test
    void returnsErrorWithInvalidWithdraw(){

        b = new BankAccount(111,"marvin");
        b.deposit(200.0);
        String actual = b.withdraw(-100.0);

        assertEquals("Invalid withdraw amount.", actual);
    }

    @Test
    void returnsErrorWithExceedingWithdrawal(){
        b = new BankAccount(111,"marvin");
        b.deposit(200.0);
        String actual = b.withdraw(205.0);

        assertEquals("Invalid withdraw amount.", actual);
    }

    @Test
    void returnsCorrectAccountNumber(){
        b = new BankAccount(111,"marvin");

        int actual = b.getAccountNumber();

        assertEquals(111,actual);
    }

    @Test
    void validCreationOfBankAccountWithNoDeposits(){
        b = new BankAccount(111,"marvin");

        double actual = b.getAvailableBalance();

        assertEquals(0.0,actual);
    }
}