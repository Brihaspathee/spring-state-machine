package com.payment.ssm.config.actions;

import com.payment.ssm.domain.PaymentEvent;
import com.payment.ssm.domain.PaymentState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 20, December 2021
 * Time: 8:36 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.config.actions
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class AuthApprovedAction implements Action<PaymentState, PaymentEvent> {
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> stateContext) {
        log.info("Sending notification of Auth approved");
    }
}
