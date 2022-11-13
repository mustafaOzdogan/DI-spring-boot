package com.example.dependencyinjectionspringboot.service;

import com.example.dependencyinjectionspringboot.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AccountServiceImpl.class})
public class AccountServiceIT
{
    private AccountService accountService;
    private ApplicationContext applicationContext;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenAccountServiceShouldBeExist()
    {
        AccountService accountServiceBean = applicationContext
                .getBean("accountService", AccountService.class);

        Assertions.assertNotNull(accountServiceBean);
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenBeanShouldBeSameWithInjected()
    {
        AccountService accountServiceBean = applicationContext
                .getBean("accountService", AccountService.class);

        Assertions.assertSame(accountService, accountServiceBean);
    }
}
