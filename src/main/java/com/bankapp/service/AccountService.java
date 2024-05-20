package com.bankapp.service;

import com.bankapp.model.Account;
import com.bankapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String firstName, String lastName, BigDecimal balance) {
        Account account = new Account(firstName, lastName, balance);
        return accountRepository.save(account);
    }

}
