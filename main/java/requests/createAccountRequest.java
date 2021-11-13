package requests;

import africa.semicolon.bankingApplication.data.models.AccountType;
import lombok.Data;

@Data
public class createAccountRequest {

    private AccountType accountType;
    private String bankId;
    private String firstName;
    private String lastName;
    private String bvn;
}
