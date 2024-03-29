package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Card;
import com.dev.clibank.domain.repository.AccountRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountFileRepository implements AccountRepository {

    private static final String ACCOUNT_FILE_NAME = "account.json";
    @Override
    public Optional<Account> getAccountNumber(String accountNumber) {
        List<Account> accountList = FileJsonManager.getFileListJson(ACCOUNT_FILE_NAME,Account.class);
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return  Optional.of(account);
            }
        }
        return Optional.empty();
    }

    @Override
    public void updatedAccount(Account updatedAccountObject) {
        Optional<Account> oldAccountObject = getAccountNumber(updatedAccountObject.getAccountNumber());
        FileJsonManager.updatedFileJson(ACCOUNT_FILE_NAME, updatedAccountObject, oldAccountObject.get(), object -> oldAccountObject.get().getAccountNumber().equals(oldAccountObject.get().getAccountNumber()),Account.class);
    }
}
