package com.bankapp.service;

import com.bankapp.model.Account;
import com.bankapp.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void should_create_account() {
        // Given
        String firstName = "John";
        String lastName = "Doe";
        BigDecimal initialBalance = BigDecimal.ZERO;

        // When
        Account expectedAccount = new Account(firstName, lastName, initialBalance);
        when(accountRepository.save(any(Account.class))).thenReturn(expectedAccount);
        Account createdAccount = accountService.createAccount(firstName, lastName, initialBalance);

        // Then
        verify(accountRepository, times(1)).save(any(Account.class));
        verifyNoMoreInteractions(accountRepository);
    }
}
