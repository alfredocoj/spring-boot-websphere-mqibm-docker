package com.skeleton.springdatasources.demo.controllers;

import com.skeleton.springdatasources.demo.dto.BankDto;
import com.skeleton.springdatasources.demo.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ws/v1/banks")
public class BankController {

    @Autowired
    private BankService service;


    @RequestMapping(method = RequestMethod.POST)
    public Object create(@Valid @RequestBody BankDto bankDto) {
        return new ResponseEntity<>(service.save(bankDto), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object read() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Object read(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody BankDto bankDto) {
        service.update(bankDto);
        return new ResponseEntity<>(bankDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<Object>("Bank deletado com sucesso", HttpStatus.OK);
    }
}