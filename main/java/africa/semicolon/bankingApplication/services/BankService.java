package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Bank;

import java.util.List;

public interface BankService {
    String createBank(String bankName);



    List<Bank> findAllBanks();

    String createAccount (String bankId, String firstName, String lastName);

}
