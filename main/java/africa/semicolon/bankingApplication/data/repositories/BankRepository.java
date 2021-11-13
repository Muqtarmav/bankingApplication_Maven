package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Customer;

import java.util.List;

public interface BankRepository {

    Bank save (Bank bank);
    Bank findBankId(String id);
    void delete(Bank customer);
    void delete(String id);
    List<Bank> findALL();

}
