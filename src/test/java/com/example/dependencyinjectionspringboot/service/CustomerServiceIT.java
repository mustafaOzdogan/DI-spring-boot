package com.example.dependencyinjectionspringboot.service;

import com.example.dependencyinjectionspringboot.service.impl.AccountServiceImpl;
import com.example.dependencyinjectionspringboot.service.impl.CustomerServiceImpl;
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
@SpringBootTest(classes = {CustomerServiceImpl.class, AccountServiceImpl.class})
public class CustomerServiceIT
{
    private CustomerService customerService;
    private ApplicationContext applicationContext;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenCustomerServiceBeanShouldBeExist()
    {
        CustomerService customerServiceBean = applicationContext
                .getBean("customerService", CustomerService.class);

        Assertions.assertNotNull(customerServiceBean);
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenBeanShouldBeSameWithInjected()
    {
        CustomerService customerServiceBean = applicationContext
                .getBean("customerService", CustomerService.class);

        Assertions.assertSame(customerService, customerServiceBean);
    }
}
