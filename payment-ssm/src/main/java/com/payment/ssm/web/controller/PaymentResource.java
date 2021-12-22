package com.payment.ssm.web.controller;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import com.payment.ssm.domain.entity.Payment;
import com.payment.ssm.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 20, December 2021
 * Time: 2:31 PM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity postPayment(@RequestBody Payment payment){
        Payment createdPayment = paymentService.createPayment(payment);
        StateMachine<PaymentState, PaymentEvent> preAuthStateMachine = paymentService.preauth(createdPayment.getPaymentId());
        if(preAuthStateMachine.getState().getId() == PaymentState.PRE_AUTH){
            log.info("Pre Auth Approved");
            StateMachine<PaymentState, PaymentEvent> authStateMachine = paymentService.authorizePayment(createdPayment.getPaymentId());
            log.info("Result of the auth:{}", authStateMachine.getState().getId());
        }else{
            log.info("payment not approved");
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
