package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {

    private BankAccount bankAccount;




    @BeforeEach
    void setup(){
        bankAccount = new BankAccount("100","John Doe",500);
    }

    @Test
    void depositValidAmount(){
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getAvailableBalance());
    }
    @Test
    void depositInvalidAmount(){
        bankAccount.deposit(-1);
        assertEquals(500, bankAccount.getAvailableBalance());
    }
    @Test
    void withdrawValidAmount(){
        bankAccount.withdraw(10);
        assertEquals(490,bankAccount.getAvailableBalance());

    }
    @Test
    void withdrawInvalidAmount(){
        bankAccount.withdraw(-100);
        assertEquals(500,bankAccount.getAvailableBalance());
    }
    @Test
    void withdrawAmountExceedingBalance(){
        bankAccount.withdraw(501);
        assertEquals(500, bankAccount.getAvailableBalance());
    }

    @Test
    void createBankAccountWithoutDeposit(){
        BankAccount bankAccountWithoutInitialDeposit = new BankAccount("101","Jane Doe");
        assertEquals(0,bankAccountWithoutInitialDeposit.getAvailableBalance());
    }


}