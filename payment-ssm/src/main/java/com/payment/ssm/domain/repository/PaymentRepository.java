package com.payment.ssm.domain.repository;

import com.payment.ssm.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 19, December 2021
 * Time: 5:09 AM
 * Project: state-machine-example
 * Package Name: com.payment.ssm.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
