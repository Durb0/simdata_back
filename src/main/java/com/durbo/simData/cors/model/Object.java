package com.durbo.simData.cors.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
@Entity(name = "objects")
public class Object extends SimData {

    @Column
    private String name;


    public Object(String name) {
        this.name = name;
    }

    public Object() {
        this.name = "";
    }
}
