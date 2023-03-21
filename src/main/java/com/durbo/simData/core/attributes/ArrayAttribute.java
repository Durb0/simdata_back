package com.durbo.simData.core.attributes;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "array_attributes")
@Data
public class ArrayAttribute extends Attribute {

    public ArrayAttribute(String name, String type) {
        super(name, type);
    }

    public ArrayAttribute() {
        super();
    }

    //TODO: getValidValues() method
}
