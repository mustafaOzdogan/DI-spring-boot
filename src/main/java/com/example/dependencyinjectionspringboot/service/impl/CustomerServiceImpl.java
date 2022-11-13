package com.example.dependencyinjectionspringboot.service.impl;

import com.example.dependencyinjectionspringboot.service.AccountService;
import com.example.dependencyinjectionspringboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("customerService")
public class CustomerServiceImpl implements CustomerService
{
    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
        log.info("Account service bean is injected by setter injection.");
    }

    public CustomerServiceImpl() {
        log.info("Customer service bean created.");
    }
}