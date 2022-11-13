package com.example.dependencyinjectionspringboot.service.impl;

import com.example.dependencyinjectionspringboot.service.AccountService;
import com.example.dependencyinjectionspringboot.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService
{
    private AccountService accountService;

    @Autowired
    public PaymentServiceImpl(AccountService accountService) {
        this.accountService = accountService;
        log.info("Account service bean injected by constructor injection and PaymentService bean created.");
    }
}
