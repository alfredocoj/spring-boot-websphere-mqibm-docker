package com.skeleton.springdatasources.demo.services;

import com.skeleton.springdatasources.demo.entities.Bank;
import com.skeleton.springdatasources.demo.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepository repository;

    public Bank save(Bank bank) {
        return repository.save(bank);
    }

    public List<Bank> findAll() {
        return repository.findAll();
    }

    public Optional<Bank> findById(Long id) {
        return repository.findById(id);
    }

    public void update(Bank bank) {
        try {
            Optional<Bank> entity = repository.findById(bank.getId());

            entity.ifPresent(e -> {
                        e.setName(bank.getName());
                        e.setAddress(bank.getAddress());
                        repository.save(e);
                    }
            );


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void delete(Long id) {
        try {
            Optional<Bank> entity = repository.findById(id);
            entity.ifPresent(e -> {
                        repository.delete(e);
                    }
            );

            //log.info("Deletado com sucesso: " + entity.getId() + " - " + entity.getNome());
        } catch (Exception ex) {
            //log.error("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }

    }
}
