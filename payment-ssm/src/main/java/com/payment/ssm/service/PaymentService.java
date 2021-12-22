package com.payment.ssm.service;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import com.payment.ssm.domain.entity.Payment;
import org.springframework.statemachine.StateMachine;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:42 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.service
 * To change this template use File | Settings | File and Code Template
 */
public interface PaymentService {

    Payment createPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preauth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
