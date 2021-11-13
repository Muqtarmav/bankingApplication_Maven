package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.repositories.BankRepository;
import africa.semicolon.bankingApplication.data.repositories.BankRepositoryImpl;
import requests.createAccountRequest;

import java.util.List;

public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository = new BankRepositoryImpl();
    private final CustomerService customerService = new CustomerServiceImpl();
    private static int lastAccountNumber;
//    private static int lastBankCreated;


    @Override
    public String createBank(String bankName) {
        String bankID = generateBankId();
        Bank bank = new Bank(bankID);
        bank.setName(bankName);
        Bank savedBank = bankRepository.save(bank);

        return savedBank.getId();
    }

    public String generateBankId(){
        int lastBankIdCreated =  findAllBanks().size();
        return String.format("%02d",  ++ lastBankIdCreated );


    }
    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findALL();
    }


    @Override
    public String createAccount(String bankId, String firstName, String lastName ) {
        String accountSuffixNumber = generateSuffixFor(bankId);
        Account account = new Account();
        account.setNumber(bankId + accountSuffixNumber);
        Bank bank = bankRepository.findBankId(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
        return account.getNumber();
    }


    private String generateSuffixFor(String bankId) {
        Bank bank = bankRepository.findBankId(bankId);
        int lastNumber = bank.getAccounts().size();
       String accountSuffix = String.format("%08d", ++lastNumber);
       return accountSuffix;


        // return String.format("%08d", ++lastNumber);


    }




}




