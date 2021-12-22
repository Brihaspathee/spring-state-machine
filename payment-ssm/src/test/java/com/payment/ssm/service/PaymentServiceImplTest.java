package com.payment.ssm.service;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import com.payment.ssm.domain.entity.Payment;
import com.payment.ssm.domain.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 20, December 2021
 * Time: 6:28 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.service
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @RepeatedTest(10)
    void preAuth(){
        Payment savedPayment = paymentService.createPayment(payment);
        StateMachine<PaymentState, PaymentEvent> stateMachine = paymentService.preauth(savedPayment.getPaymentId());
        Payment preAuthedPayment = paymentRepository.getById(savedPayment.getPaymentId());
        log.info("State Machine: {}", stateMachine.getState().getId());
        log.info("Pre Auth Payment:{}",preAuthedPayment);
    }

    @Transactional
    @RepeatedTest(10)
    void testAuth(){
        Payment savedPayment = paymentService.createPayment(payment);
        StateMachine<PaymentState, PaymentEvent> preAuthStateMachine = paymentService.preauth(savedPayment.getPaymentId());
        if(preAuthStateMachine.getState().getId() == PaymentState.PRE_AUTH){
            log.info("Payment is pre authorized");
            StateMachine<PaymentState, PaymentEvent> authSM = paymentService.authorizePayment(savedPayment.getPaymentId());
            log.info("Result of the auth:{}", authSM.getState().getId());
        }else{
            log.info("Payment failed pre-auth...");
        }
    }
}