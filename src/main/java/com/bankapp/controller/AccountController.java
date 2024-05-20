package com.bankapp.controller;

import com.bankapp.model.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam BigDecimal balance) {
        Account createdAccount = accountService.createAccount(firstName, lastName, balance);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

}
