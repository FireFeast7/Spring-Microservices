package org.backend.rabbitmq.repository;

import org.backend.rabbitmq.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
