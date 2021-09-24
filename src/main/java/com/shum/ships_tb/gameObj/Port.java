package com.shum.ships_tb.gameObj;

import com.shum.ships_tb.gameObj.interfaces.CanHaveCargo;
import com.shum.ships_tb.gameObj.interfaces.CanStringCargoTransformation;
import com.shum.ships_tb.repository.entity.RepoPort;

import java.util.ArrayList;
import java.util.List;

/**
 * realisation of port func
 */

public class Port implements CanHaveCargo, CanStringCargoTransformation {

    private final RepoPort repoPort; //preset of port from db.
    private List<Cargo> cargo = new ArrayList<>();
    public Port(RepoPort repoPort) {
        this.repoPort = repoPort;
        turnStringIntoCargo(repoPort.getCargo(), extraRegex,introRegex, cargo);
    }


    @Override
    public List<Cargo> getCargo() {
        return cargo;
    }

    @Override
    public void trade() {

    }
}
