package com.shum.ships_tb.gameObj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.shum.ships_tb.ShipsBot;
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

    public Cargo(RepoCargo repoCargo, int quantity) {
        if (repoCargo == null) return;
        this.name = repoCargo.getName();
        this.weight = repoCargo.getWeight();
        setQuantity(quantity);
        this.thisTotalWeight = setTotalWeight(quantity);
    }

    public Cargo(String name, int quantity) {
        RepoCargo rc = getRC(name);
        if (rc == null) return;
        this.name = rc.getName();
        this.weight = rc.getWeight();
        setQuantity(quantity);
        this.thisTotalWeight = setTotalWeight(quantity);
    }

    private RepoCargo getRC(String name) {
        /**
         * its find in db copy of cargos equal RepoCargo
         * if its not return null
         * */
        RepoCargo buf = null;
        for (RepoCargo rc : ShipsBot.listCargo) {
            buf = (rc.getName().equals(name)) ? rc : buf;
        }
        return buf;
    }


    public int setTotalWeight(int quantity) {
        return this.weight * quantity;
    }

    public int getThisTotalWeight() {
        /**
         *set and return current tw
         * */
        this.thisTotalWeight = setTotalWeight(this.quantity);
        return this.thisTotalWeight;
    }

    public int setQuantity(int quant) {
        /**
         * increase (or decrease if you sent quant pram with minus)
         * quantity of this cargo
         */

            if (this.quantity + quant < 0) {
                if (this.quantity + quant == 0) {
                    System.out.println("this quantity is 0; its may remove from ship");
                    this.quantity = this.quantity + quant;
                }
            } else this.quantity = Math.max(this.quantity + quant, 0);
        return this.quantity;
    }


    public int setWeight(int weight) {
        this.weight = Math.max(weight, 0);
        return this.weight;
    }
}
