package com.dev.clibank.domain.repository;

import com.dev.clibank.domain.entities.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> getAccountNumber(String accountNumber);
    void updatedAccount(Account account);
}
