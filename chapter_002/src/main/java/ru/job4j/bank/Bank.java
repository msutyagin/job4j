package ru.job4j.bank;


import java.util.*;

/**
 * Класс реализует Map для банка.
 * @author Максим Сутягин (m.sutyagin.m@gmail.com)
 */
public class Bank {
    private final Map<User, List<Account>> bank = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в Map.
     * @param user - пользователь для добавления.
     */
    public void addUser(User user) {
        this.bank.putIfAbsent(user, null);
    }

    /**
     * Метод удаляет пользователя из Map.
     * @param user - Пользователь, которого необходимо удалить.
     */
    public void deleteUser(User user) {
        bank.remove(user);
    }

    /**
     * Метод для получения пользователя по паспорту.
     * @param passport - пасспорт пользователя.
     * @return - Пользователя - владельца указанного паспорта.
     * @throws UserNotFoundException - Исключение, если пользователь с таким паспортом не найден в Map.
     */
    public User getUserByPassport(String passport) {
        User result = new User();
        Set<User> keys = this.bank.keySet();
        for (Iterator<User> it = keys.iterator(); it.hasNext();) {
            User user = it.next();
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            } else {
                result = null;
            }
        }
        return result;
    }

    /**
     * Метод для добавления счета для Пользователя.
     * @param passport - пасспорт пользователя, котрому надо добавить счет.
     * @param account - счет который добавляем пользователю.
     */
    public void addAccountToUser(String passport, Account account) {
        User user = this.getUserByPassport(passport);
        List<Account> accounts = this.getUserAccounts(user.getPassport());
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        this.bank.putIfAbsent(user, accounts);
    }

    /**
     * Метод для удаления счета у пользователя.
     * @param passport - Паспорт пользователя, которому надо удалить счет.
     * @param account - Счет пользователя для удаления.
     * @throws UserNotFoundException - Исключение, если пользователь не найден.
     */
    public void deleteAccountFromUser(String passport, Account account) throws UserNotFoundException {
        User user = this.getUserByPassport(passport);
        List<Account> accounts = this.bank.get(user);
        if (accounts.contains(account)) {
            accounts.remove(account);
        } else {
            throw new UserNotFoundException("Пользователь с таким паспортом не найден!");
        }
    }

    /**
     * Метод для получения списка счетов пользователя.
     * @param passport - Паспорт пользователя по которому надо вернуть список счетов.
     * @return - Список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        User user = this.getUserByPassport(passport);
        if (user != null) {
            result = this.bank.get(user);
        }
        return result;
    }

    /**
     * Метод для получения счет пользователя по пользователю и реквизитам.
     * @param user Пользователь, кому принадлежит счет.
     * @param requisite - Реквизиты счета, который необходимо вернуть.
     * @return - Счет.
     */
    public Account getAccountByRequisite(User user, String requisite) {
        Account result = new Account();
        List<Account> accounts = this.bank.get(user);
        for (Account el : accounts) {
            if (el.getRequisites().equals(requisite)) {
                result = el;
                break;
            } else {
                result = null;
            }
        }
        return result;
    }

    /**
     * Метод для получения счет пользователя по паспорту и реквизитам счета.
     * @param passport - Паспорт пользователя.
     * @param requisite - Номер счета пользователя.
     * @return - Счет пользователя.
     */
    public Account getAccountByRequisite(String passport, String requisite) {
        User user = new User();
        Account result = new Account();
        try {
            user = this.getUserByPassport(passport);
        } catch (UserNotFoundException unfe) {
            System.out.println("Пользователь с таким паспортом не найден!");
        }
        try {
            result = this.getAccountByRequisite(user, requisite);
        } catch (UserNotFoundException unfe) {
            System.out.println("Пользователь с таким счетом не найден!");
        }
        return result;
    }
    /**
     * Метод для перевода ДС между счетами пользователя(ей).
     * @param srcPassport - пасспорт отправителя.
     * @param srcRequisite - реквизиты счета отправителя.
     * @param destPassport - пасспорт получателя.
     * @param destRequisite - реквизиты счета получателя.
     * @param amount - сумма перевода.
     * @return - 1 в случае успеха операции, 0 - в случае неуспеха.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount)
            throws RequisiteNotFoundExeption, UserNotFoundException {
        boolean result = false;
        Account srcAccount = this.getAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = this.getAccountByRequisite(destPassport, destRequisite);
        if (srcAccount.getValue() >= amount || destAccount == null) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }
}
