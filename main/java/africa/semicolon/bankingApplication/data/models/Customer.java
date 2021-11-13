package africa.semicolon.bankingApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private List<Account> accounts = new ArrayList<>();
    private String bvn;
    private String firstName;
    private String lastName;

}
