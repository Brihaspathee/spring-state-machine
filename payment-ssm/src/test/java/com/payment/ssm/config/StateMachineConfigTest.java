package com.payment.ssm.config;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:22 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.config
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    void testNewStateMachine(){
        StateMachine<PaymentState, PaymentEvent> sm = factory.getStateMachine(UUID.randomUUID());
        sm.start(); //This method is deprecated in favor of StateMachineReactiveLifecycle.startReactively()
        log.info(sm.getState().toString());
        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        log.info(sm.getState().toString());
        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);
        log.info(sm.getState().toString());


    }

}