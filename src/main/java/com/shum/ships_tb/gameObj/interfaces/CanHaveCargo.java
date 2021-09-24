package com.shum.ships_tb.gameObj.interfaces;

import com.shum.ships_tb.gameObj.Cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * declaration and basic realisation of interactions with cargos
 */

public interface CanHaveCargo {

    List<Cargo> getCargo();

    default void setCargo(String cargoName, int quantity){
        /**
         * try to find cargo et ship
         * in success add quant. if summ ==0 its remove or its remove from cargo bay,
         * or if less than 0 operation denied
         * if you try to set cargo without its quant - its denied
         * */
        for (Cargo crg :getCargo()) {
            if (crg.getName().equals(cargoName)) {
                int i = crg.getQuantity()+quantity;
                if(i<1){
                    if (i==0) {
                        removeCargo(cargoName);
                    }
                    return;
                }
                crg.setQuantity(quantity);
                return;
            }
        }
        Cargo cg = new Cargo(cargoName, quantity);
        if (cg.getName()!= null && quantity>0) getCargo().add(cg);
    }

    default void removeCargo(String cargoName){
        for (int i = 0; i < getCargo().size(); i++) {
            if (Objects.equals(getCargo().get(i).getName(), cargoName)) getCargo().remove(i);
        }
    }

    default void removePieceOfCargo(String cargoName, int howmuch){
        setCargo(cargoName, -howmuch);
    }


    void trade();


}
