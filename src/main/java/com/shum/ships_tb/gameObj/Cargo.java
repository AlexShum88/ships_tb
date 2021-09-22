package com.shum.ships_tb.gameObj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.shum.ships_tb.repository.entity.RepoCargo;
import lombok.Data;


/*realisation of cargo obj*/
@JsonAutoDetect
@Data
public class Cargo {

    private String name;
    private int weight;
    private int thisTotalWeight;
    private int quantity;

    public Cargo(){}

    public Cargo(String name, int weight) {
        this.name = name;
        this.weight = setWeight(weight);
        this.thisTotalWeight = setWeight(weight);
        this.quantity = 1;
    }


    public Cargo (RepoCargo repoCargo, int quantity){
        this.name= repoCargo.getName();
        this.weight = repoCargo.getWeight();
        this.quantity = setQuantity(quantity);
        this.thisTotalWeight = setTotalWeight(quantity);
    }

    public int setTotalWeight(int quantity) {
        return this.weight*quantity;
    }

    public int  setQuantity (int quant){
        this.quantity = Math.max(quant, 1);
        return this.quantity;
    }

    public int setWeight(int weight){
        this.weight= Math.max(weight, 0);
        return this.weight;
    }
}
