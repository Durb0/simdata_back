package com.durbo.simData.cors.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "proposals")
public class Proposal<T> extends SimData{

    @Column
    private T value;

    public Proposal() {
        this.value = null;
    }

    public Proposal(T value) {
        this.value = value;
    }

}
