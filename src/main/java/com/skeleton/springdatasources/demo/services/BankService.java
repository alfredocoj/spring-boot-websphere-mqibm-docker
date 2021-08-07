package com.skeleton.springdatasources.demo.services;

import com.skeleton.springdatasources.demo.dto.BankDto;
import com.skeleton.springdatasources.demo.entities.Bank;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private com.skeleton.springdatasources.demo.repositories.BankRepository repository;

    Logger logger = LoggerFactory.getLogger(BankService.class);

    public Bank save(BankDto bankDto) {
        try {
            return repository.save(new Bank(bankDto.getName(), bankDto.getAddress()));
        } catch (HibernateException ex) {
            String errorMessage = String.format("Error in save of bank -> bank: { {1} } - error message: " + ex.getMessage(), bankDto);
            logger.error(errorMessage);
            throw new HibernateException(errorMessage);
        }
    }

    public List<BankDto> findAll() {
        List<Bank> banks = repository.findAll();
        List<BankDto> bankDtos = new ArrayList<>();
        for (Bank bank : banks) {
            BankDto bankDto = new BankDto(bank.getId(), bank.getName(), bank.getAddress());
            bankDtos.add(bankDto);
        }
        return bankDtos;
    }

    public BankDto findById(Long id) {
        if (Objects.nonNull(id)) {
            Optional<Bank> entity = repository.findById(id);
            if (entity.isPresent()) {
                return new BankDto(entity.get().getId(), entity.get().getName(), entity.get().getAddress());
            }
        }
        return new BankDto();
    }

    public void update(BankDto bankDto) {
        try {
            if (Objects.nonNull(bankDto.getId())) {
                Optional<Bank> entity = repository.findById(bankDto.getId());

                entity.ifPresent(bank -> {
                            bank.setName(bankDto.getName());
                            bank.setAddress(bankDto.getAddress());
                            repository.save(bank);
                            logger.info("Atualização realizada com sucesso: { " + bank + " }");
                        }
                );
            }
        } catch (HibernateException ex) {
            String errorMessage = String.format("Error in update of bank -> bank: { {1} } - error message: " + ex.getMessage(), bankDto);
            logger.error(errorMessage);
            throw new HibernateException(errorMessage);
        }

    }

    public void delete(Long id) {
        try {
            Optional<Bank> entity = repository.findById(id);
            entity.ifPresent(bank -> {
                        repository.delete(bank);
                        logger.info("Deletado com sucesso: " + bank.getId() + " - " + bank.getName());
                    }
            );

        } catch (HibernateException ex) {
            String errorMessage = String.format("Error in delete of bank -> id: { {1} } - error message: " + ex.getMessage(), id);
            logger.error(errorMessage);
            throw new HibernateException(errorMessage);
        }

    }
}
