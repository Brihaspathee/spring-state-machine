package com.payment.ssm.domain;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:05 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.domain
 * To change this template use File | Settings | File and Code Template
 */
public enum PaymentEvent {

    PRE_AUTHORIZE, PRE_AUTH_APPROVED, PRE_AUTH_DECLINED, AUTHORIZE, AUTH_APPROVED, AUTH_DECLINED
}
