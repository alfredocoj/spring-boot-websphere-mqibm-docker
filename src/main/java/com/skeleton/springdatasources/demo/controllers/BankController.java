package com.skeleton.springdatasources.demo.controllers;

import com.skeleton.springdatasources.demo.entities.Bank;
import com.skeleton.springdatasources.demo.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/")
public class BankController {

    @Autowired
    private BankService service;


    @RequestMapping(value="banks",method= RequestMethod.POST)
    public Object create(@RequestBody Bank bank) {
        return new ResponseEntity<>(service.save(bank), HttpStatus.CREATED);
    }

    @RequestMapping(value={"banks"}, method=RequestMethod.GET)
    public Object read() {
        return new ResponseEntity<List<Bank>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value={"banks/{id}"}, method=RequestMethod.GET)
    public Object read(@PathVariable Long id) {
        Optional<Long> op = Optional.ofNullable(id);

        if(op.isPresent()) {
            return new ResponseEntity<Bank>(service.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Não encontrado", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value="banks", method=RequestMethod.PUT)
    public Object update(@RequestBody Bank bank) {
        service.update(bank);
        return new ResponseEntity<Bank>(bank, HttpStatus.CREATED);
    }

    @RequestMapping(value="banks/{id}", method=RequestMethod.DELETE)
    public Object delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<Object>("Bank deletado com sucesso", HttpStatus.OK);
    }
}