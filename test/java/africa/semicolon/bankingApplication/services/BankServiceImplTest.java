package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {
    BankService bankService;
    private String gtCoId;


    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bankService = null;
    }


    @Test
    void createBank() {
        String bankId = bankService.createBank("GTCO");
        assertEquals("01", bankId);
    }

    @Test
    void createTwoBanksAndTheSecoundBankIdWillBe02() {
        String ftCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("first Bank");
        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);

    }

    @Test
    void createTwoBanksAndRepositoryShouldHaveTwoBanks() {
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("first Bank");

        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);
        assertEquals(2, bankService.findAllBanks().size());

    }

    @Test
    void banksCanCreateAccountForCustomersTests() {
        String gtCoId = bankService.createBank("GTCO");

        String accountNumber = bankService.createAccount("01", "John", "Doe");
        assertEquals("0100000001", accountNumber);

    }

    @Test
    void createTwoAccountInBankOne_SecondAccountNumberShouldBe02() {

        String gtCoId = bankService.createBank("GTCO");
        String johnAccountNumber = bankService.createAccount("01", "John", "Doe");
        String janeAccountNumber = bankService.createAccount("01", "Jane", "Doe");

        assertEquals("0100000001", johnAccountNumber);
        assertEquals("0100000002", janeAccountNumber);

    }

    @Test
    void createTwoAccountsInTwoBanks() {
        //given
        String gTCoId = bankService.createBank("GTCO");
        String firstBank = bankService.createBank("FIRST bank");
        //when
        String johnGTCO_accountNumber = bankService.createAccount("01", "John", "Doe");
        String paulGTCO_accountNumber = bankService.createAccount("01", "Paul", "Sam");
        String millFirstBank_accountNumber = bankService.createAccount("02", "Mill", "Moore");
        String emmyFirstBank_accountNumber = bankService.createAccount("02", "Emmy", "Lexy");

        //assert
        assertEquals("0100000001", johnGTCO_accountNumber);
        assertEquals("0100000002", paulGTCO_accountNumber);
        assertEquals("0200000001", millFirstBank_accountNumber);
        assertEquals("0200000002", emmyFirstBank_accountNumber);

    }
}