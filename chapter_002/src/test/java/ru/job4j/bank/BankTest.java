package ru.job4j.bank;

import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тестироваие класса Bank.
 * @author Максим Сутягин (m.sutyagin.m@gmail.com)
 */
public class BankTest {

    /**
     * Тестирование метода getUserByPassport.
     */
    @Test
    public void whenInputPassportThanReturnUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Вася", "1234"));
        bank.addUser(new User("Вова", "0000"));
        User result = bank.getUserByPassport("1234");
        User ex = new User("Вася", "1234");
        assertThat(result, is(ex));
    }

    /**
     * Тестирование метода addAccountToUser.
     */
    @Test
    public void whenAccountAddedToUserThanUserHasIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Вася", "1234"));
        bank.addUser(new User("Вова", "0000"));
        Account account = new Account(5000, "0001");
        bank.addAccountToUser("1234", account);
        List<Account> accounts = bank.getUserAccounts("1234");
        Account result = accounts.get(0);
        Account ex = new Account(5000, "0001");
        assertThat(result, is(ex));
    }

    /**
     * Тестирование метода deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUserThanUserHadNotIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Вася", "1234"));
        bank.addUser(new User("Вова", "0000"));
        Account account = new Account(5000, "0001");
        bank.addAccountToUser("1234", account);
        bank.deleteAccountFromUser("1234", account);
        List<Account> res = bank.getUserAccounts("1234");
        List<Account> ex = new ArrayList<>();
        assertThat(res, is(ex));
    }

    /**
     * Тестирование метода getUserAccounts.
     */
    @Test
    public void whenUserHasAccountsThanReturnThem() {
        Bank bank = new Bank();
        bank.addUser(new User("Вася", "1234"));
        bank.addUser(new User("Вова", "0000"));
        Account account = new Account(5000, "0001");
        bank.addAccountToUser("1234", account);
        List<Account> res = bank.getUserAccounts("1234");
        List<Account> ex = new ArrayList<>();
        ex.add(account);
        assertThat(res, is(ex));
    }

    /**
     * Тестирование метода getAccountByRequisite.
     */
    @Test
    public void whenAskedAccountsByRequisitesThanReturnIt() {
        Bank bank = new Bank();
        User usr1 = new User("Вася", "1234");
        User usr2 = new User("Вова", "0000");
        bank.addUser(usr1);
        bank.addUser(usr2);
        Account account1 = new Account(5000, "0001");
        Account account2 = new Account(10000, "0002");
        bank.addAccountToUser("1234", account1);
        bank.addAccountToUser("1234", account2);
        Account res = bank.getAccountByRequisite(usr1, "0001");
        Account ex = account1;
        assertThat(res, is(ex));
    }

    /**
     * Тестирование метода transferMoney.
     */
    @Test
    public void whenMoneyTransferedThanItWas() {
        Bank bank = new Bank();
        User usr1 = new User("Вася", "1234");
        User usr2 = new User("Вова", "0000");
        bank.addUser(usr1);
        bank.addUser(usr2);
        Account account1 = new Account(5000, "0001");
        Account account2 = new Account(10000, "0002");
        bank.addAccountToUser("1234", account1);
        bank.addAccountToUser("0000", account2);
        boolean res = bank.transferMoney("0000", "0002", "1234", "0001", 5000);
        assertThat(res, is(true));
    }

}
