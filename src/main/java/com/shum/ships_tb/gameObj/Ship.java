package com.shum.ships_tb.gameObj;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.gameObj.interfaces.CanHaveCargo;
import com.shum.ships_tb.gameObj.interfaces.CanMove;
import com.shum.ships_tb.repository.entity.RepoCargo;
import com.shum.ships_tb.repository.entity.RepoShip;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
* realisation of ship func
* */

@Data
public class Ship implements CanMove, CanHaveCargo {
    //ship fields from db
    private RepoShip rsh;
    //collection of cargos for this ship
    private List<Cargo> cargo = new ArrayList<>();

    public Ship(RepoShip rp) { //refactoring needed

        rsh = rp;

        turnStringIntoCargo(rsh.getCargo_map(), ", ", ":");
    }


    @Override
    public void setCargo() {

    }

    @Override
    public void removeCargo() {

    }

    @Override
    public void trade() {

    }

    @Override
    public void refuel(int fuel) {
        //if (fuel > 0 && rsh.getFuel() + fuel <= rsh.getMaxFuel())
        rsh.setFuel(fuel);
    }

    @Override
    public void sendOnTrip() {

    }

    private RepoCargo getCargoData(String cargoName) {
        /*support method to turnStringIntoCargo.
         take name of cargo and get info about cargo from db*/
        for (RepoCargo rp : ShipsBot.listCargo) {
            if (Objects.equals(cargoName, rp.getName())) return rp;
        }
        return null;
    }

    private void turnStringIntoCargo(String fromdb, String extraRegex, String introRegex) {
        /*get string from RepoShip cargo_map and convert it to cargo obj
        * to cargo list
        * regex needed to split string to array of cargos*/
        String[] first = fromdb.split(extraRegex);
        for (int i = 0; i < first.length; i++) {
            String[] second = first[i].split(introRegex);
            RepoCargo rsh = Objects.requireNonNull(getCargoData(second[0]));
            int count = Integer.parseInt(second[1]);
            cargo.add(new Cargo(rsh, count));
        }

    }

}
