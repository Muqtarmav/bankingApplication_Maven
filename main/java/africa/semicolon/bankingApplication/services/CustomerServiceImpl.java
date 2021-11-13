
package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepositoryImpl;
import responses.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override

    public String createAccount(String firstName, String lastName) {
    return null;
    }

    @Override

        public String createAccount (String firstName, String lastName, String bvn){
            return null;
        }

//    @Override
//    public List<CustomerResponse> findAll() {
//        List<CustomerResponse> responses = new ArrayList<>();
//        List<Customer> ourRealCustomers = customerRepository.findALL();
//
//        for(Customer customer : ourRealCustomers){
//            responses.add(new CustomerResponse(customer));
//        }
//        return responses;
//    }
}




//
//        @Override
//        public Customer createAccount (String firstName, String lastName, String bvn){
//            return null;
//        }




