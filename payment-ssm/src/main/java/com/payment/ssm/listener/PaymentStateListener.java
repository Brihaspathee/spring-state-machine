package com.payment.ssm.listener;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:35 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.listener
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class PaymentStateListener extends StateMachineListenerAdapter<PaymentState, PaymentEvent> {

    @Override
    public void stateChanged(State<PaymentState, PaymentEvent> from, State<PaymentState, PaymentEvent> to) {
        log.info(String.format("stateChanged(from: %s, to %s)", from, to));
    }
}
