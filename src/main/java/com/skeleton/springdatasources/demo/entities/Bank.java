package com.skeleton.springdatasources.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank extends EntityBase {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "address")
    private String address;
}
