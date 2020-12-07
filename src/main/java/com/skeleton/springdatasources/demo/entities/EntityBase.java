package com.skeleton.springdatasources.demo.entities;

import javax.persistence.*;

@Entity
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id", sequenceName = "id")
    @Column(name="id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
