package com.durbo.simData.cors.model;

import jakarta.persistence.*;

@lombok.Data
@Entity(name = "datas")
public abstract class SimData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
