package com.example.dependencyinjectionspringboot.service.impl;

import com.example.dependencyinjectionspringboot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("accountService")
public class AccountServiceImpl implements AccountService
{
    public AccountServiceImpl() {
        log.info("Account service bean created.");
    }
}
