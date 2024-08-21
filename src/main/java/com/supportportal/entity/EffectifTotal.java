package com.supportportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EffectifTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int effectiveTotal;

    // Constructors
    public EffectifTotal() {}

    public EffectifTotal(int effectiveTotal) {
        this.effectiveTotal = effectiveTotal;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEffectiveTotal() {
        return effectiveTotal;
    }

    public void setEffectiveTotal(int effectiveTotal) {
        this.effectiveTotal = effectiveTotal;
    }

	
}