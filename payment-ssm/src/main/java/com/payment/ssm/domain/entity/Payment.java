package com.payment.ssm.domain.entity;

import com.payment.ssm.domain.PaymentState;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:07 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private PaymentState state;

    private BigDecimal amount;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", state=" + state +
                ", amount=" + amount +
                '}';
    }
}
