package com.shum.ships_tb.gameObj;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.gameObj.interfaces.CanHaveCargo;
import com.shum.ships_tb.gameObj.interfaces.CanMove;
import com.shum.ships_tb.gameObj.interfaces.CanStringCargoTransformation;
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
public class Ship implements CanMove, CanHaveCargo, CanStringCargoTransformation {
    //ship fields from db
    private RepoShip rsh;
    //collection of cargos for this ship
    private List<Cargo>cargo = new ArrayList<>();

    public Ship(RepoShip rp) { //refactoring needed

        rsh = rp;

        turnStringIntoCargo(rsh.getCargo_map(), extraRegex, introRegex, cargo);
    }


    @Override
    public List<Cargo> getCargo() {
        return cargo;
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

    public RepoShip getRsh() {
        rsh.setCargo_map(this.turnCargoIntoString(cargo, extraRegex, introRegex));
        return rsh;
    }
}
