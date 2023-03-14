package com.durbo.simData.cors.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "attributes")
public class Attribute <T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    //list of proposals
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Proposal.class)
    private List<Proposal<T>> proposals = new ArrayList<Proposal<T>>();

    public Attribute(String name) {
        this.name = name;
        this.proposals = new ArrayList<Proposal<T>>();
    }

    public Attribute() {
        this.name = "";
        this.proposals = new ArrayList<Proposal<T>>();
    }

    public void addProposal(Proposal<T> proposal) {
        this.proposals.add(proposal);
    }

    public void removeProposal(Proposal<T> proposal) {
        this.proposals.remove(proposal);
    }

    public List<Proposal<T>> getProposals() {
        return this.proposals;
    }
}
