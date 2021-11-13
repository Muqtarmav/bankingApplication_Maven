package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;

import java.util.List;

public interface AccountRepository {

    Account save  (Account account);
    Account findByAccountId(String id);
    void delete(Account account);
    void delete (String number);
    List<Account> findAll();



}
