package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.services.BankService;

import java.util.ArrayList;
import java.util.List;


public class BankRepositoryImpl implements BankRepository{
    List<Bank>banks  = new ArrayList<>();

    @Override
    public Bank save(Bank bank) {
        Bank foundBank = findBankId(bank.getId());
        if(foundBank != null){
            delete(foundBank);
        }
        banks.add(bank);
        return findBankId(bank.getId());
    }

    @Override
    public Bank findBankId(String id) {
        for (Bank bank : banks){
            if (bank.getId().equalsIgnoreCase(id)){
                return bank;
            }
        }
        return null;
    }

    @Override
    public void delete(Bank bank) {
        banks.remove(bank);

    }

    @Override
    public void delete(String id) {
        Bank bank = findBankId(id);
        delete(bank);
    }

    @Override
    public List<Bank> findALL() {
        return banks;
    }
}

