package africa.semicolon.bankingApplication.data.models;

import lombok.Data;


import java.math.BigDecimal;

@Data

public class Account {
    private BigDecimal balance = BigDecimal.ZERO;
    private String customerId;
    private String number;
    private AccountType type;


}
