package com.skeleton.springdatasources.demo.repositories;

import com.skeleton.springdatasources.demo.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
