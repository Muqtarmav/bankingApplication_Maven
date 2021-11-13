package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accounts.add(account);
        return account;
    }


    @Override
    public Account findByAccountId(String id) {
        for (Account account : accounts) {
            if (account.getCustomerId().equalsIgnoreCase(id)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void delete(Account account) {
        accounts.remove(account);
    }


    @Override
    public void delete(String number) {
        Account account = findByAccountId(number);
        delete(account);

    }

    @Override
    public List<Account> findAll() {

        return accounts;
    }
}
