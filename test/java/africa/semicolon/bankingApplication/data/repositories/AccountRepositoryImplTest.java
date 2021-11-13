package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.AccountType;
import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
     AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Account account = new Account();
        Customer customer = new Customer();

        Bvn bvn = new Bvn("2345616234", customer);
        account.setCustomerId(bvn.getId());
        account.setNumber("2109250197");
        account.setType(AccountType.SAVINGS);
        Account savedAccount = accountRepository.save(account);
        assertEquals(account, savedAccount);

    }

    @Test
    void findByAccountId() {
        save();
        accountRepository.findByAccountId("2345616234");
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("2345616234", customer);
        account.setCustomerId(bvn.getId());
        account.setNumber("Ojo");
        //account.setType("mav");

        Account savedAccount = accountRepository.save(account);
        Account foundAccount = accountRepository.findByAccountId("2345616234");
        assertEquals(savedAccount, foundAccount);

    }

    @Test
    void delete() {
        Account account = new Account();
        Customer customer = new Customer();

        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn("2345616234");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0022446688");
        account.setType(AccountType.SAVINGS);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        assertNotNull(accountRepository.findByAccountId("2345616234"));
        accountRepository.delete("0022446688");

        assertNull(accountRepository.findByAccountId("0022446688"));
    }

    @Test
    void testDelete() {
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("2345616234");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0022446688");
        accountRepository.save(account);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);

        assertNotNull(accountRepository.findByAccountId("2345616234"));
        accountRepository.delete("2345616234");

        assertNotNull(accountRepository.findByAccountId("2345616234"));
    }

    @Test
    void findAll() {

        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("2345616234");
       // Bvn bvn = new Bvn("2345616234", customer);
        account.setCustomerId(customer.getBvn());
        account.setNumber("0022446688");
        account.setType(AccountType.SAVINGS);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);

        assertEquals(3, accountRepository.findAll().size());
    }
    }


