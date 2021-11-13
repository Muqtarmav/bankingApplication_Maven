package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.AssertNull.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerRepositoryImplTest {
    private CustomerRepository customerRepository;
   // private Object CustomerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("mav");
        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(customer, savedCustomer);

    }

    @Test
    void findByCustomerId() {
        save();
        customerRepository.findByCustomerId("2345616234");
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("mav");

        Customer savedCustomer = customerRepository.save(customer);
        Customer foundCustomer = customerRepository.findByCustomerId("2345616234");
         assertEquals(savedCustomer, foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("mav");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("2345616234"));
        customerRepository.delete("2345616234");
      //  assertNull(customerRepository, findByCustomerId("2345616234"));
//
//        Customer savedCustomer = customerRepository.save(customer);
//        Customer foundCustomer = customerRepository.findByCustomerId("2345616234");
//        assertEquals(savedCustomer, foundCustomer);

    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("mav");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("2345616234"));
        customerRepository.delete("2345616234");
      //  assertNull(customerRepository, findByCustomerId("2345616234"));

    }

    @Test
    void findALL() {

        Customer customer = new Customer();
        Bvn bvn = new Bvn("2345616234", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("mav");
        customerRepository.save(customer);
        customerRepository.save(customer);
        customerRepository.save(customer);

        assertEquals(3, customerRepository.findALL().size());
    }
}