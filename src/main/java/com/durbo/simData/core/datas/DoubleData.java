package com.durbo.simData.core.datas;

import com.durbo.simData.core.TYPE;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class DoubleData extends SimData {

    @Column
    private double value;


    public DoubleData() {
        super(TYPE.DOUBLE);
        this.value = 0.0;
    }

    public DoubleData(double value) {
        super(TYPE.DOUBLE);
        this.value = value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (double) value;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}
