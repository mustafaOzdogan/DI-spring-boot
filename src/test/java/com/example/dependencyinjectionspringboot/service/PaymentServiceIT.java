package com.example.dependencyinjectionspringboot.service;

import com.example.dependencyinjectionspringboot.service.impl.AccountServiceImpl;
import com.example.dependencyinjectionspringboot.service.impl.PaymentServiceImpl;
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
@SpringBootTest(classes = {PaymentServiceImpl.class, AccountServiceImpl.class})
public class PaymentServiceIT
{
    private PaymentService paymentService;
    private ApplicationContext applicationContext;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenBeanShouldBeExist()
    {
        PaymentService paymentServiceBean = applicationContext
                .getBean("paymentService", PaymentService.class);

        Assertions.assertNotNull(paymentServiceBean);
    }

    @Test
    public void givenAppContext_WhenLookUp_ThenBeanShouldBeSameWithInjected()
    {
        PaymentService paymentServiceBean = applicationContext
                .getBean("paymentService", PaymentService.class);

        Assertions.assertSame(paymentService, paymentServiceBean);
    }
}
