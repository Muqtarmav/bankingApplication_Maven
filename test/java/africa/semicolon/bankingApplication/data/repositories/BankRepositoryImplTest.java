package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {
    private BankRepository bankRepository;

    @BeforeEach
    void setUp() {
        bankRepository = new BankRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
      //  Customer customer = new Customer();
        Bank bank = new Bank("001");
        bank.setName("First bank");
        Bank savedBank = bankRepository.save(bank);
       //bank.setId("2345");
        assertEquals(bank, savedBank);
    }

    @Test
    void findBankId() {
        Bank bank = new Bank("001");
        bank.setId("001");
        bankRepository.save(bank);

        Bank foundBank = bankRepository.findBankId("001");
        assertEquals(bank, foundBank);
    }

    @Test
    void delete() {
        Bank bank = new Bank("001");
        bank.setName("first bank");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findBankId("001"));
        bankRepository.delete(bank);
        //Bank foundBank = bankRepository.findBankId("001");
        //assertEquals(bank, foundBank);
        assertNull(bankRepository.findBankId("001"));
    }

    @Test
    void testDelete() {
        Bank bank = new Bank("001");
        //bank.setId("001");
        bank.setName("first bank");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findBankId("001"));
        bankRepository.delete("001");
        assertNull(bankRepository.findBankId("001"));
    }

    @Test
    void findALL() {
        Bank bank = new Bank("001");
        bank.setId("001");
        bank.setName("first bank");
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);

        //assertEquals(3, bankRepository.findALL().size());
    }
}