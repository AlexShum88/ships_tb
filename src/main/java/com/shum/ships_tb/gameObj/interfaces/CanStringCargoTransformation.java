package com.shum.ships_tb.gameObj.interfaces;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.gameObj.Cargo;
import com.shum.ships_tb.repository.entity.RepoCargo;

import java.util.List;
import java.util.Objects;

public interface CanStringCargoTransformation {

    String extraRegex = ", ";
    String introRegex = ":";

    default void turnStringIntoCargo(String fromdb, String extraRegex, String introRegex, List<Cargo> cargoList) {
        /**
         * get string from RepoShip cargo_map and convert it to cargo obj
         * to cargo list
         * regex needed to split string to array of cargos
         * */

        String[] first = fromdb.split(extraRegex);
        for (String s : first) {
            String[] second = s.split(introRegex);
            RepoCargo rsh = Objects.requireNonNull(getCargoData(second[0]));
            int count = Integer.parseInt(second[1]);
            cargoList.add(new Cargo(rsh, count));
        }
    }

    default RepoCargo getCargoData(String cargoName) {
        /**
         * support method to turnStringIntoCargo.
         * take name of cargo and get info about cargo from db
         * */
        for (RepoCargo rp : ShipsBot.listCargo) {
            if (Objects.equals(cargoName, rp.getName())) return rp;
        }
        return null;
    }

    default String turnCargoIntoString (List<Cargo>listCargo, String extraRegex, String introRegex){
        StringBuilder resualt = new StringBuilder();
        for (int i =0; i<listCargo.size(); i++) {
            Cargo cargo = listCargo.get(i);
            resualt.append(cargo.getName());
            resualt.append(introRegex);
            resualt.append(cargo.getQuantity());
            if (i!=listCargo.size()-1) resualt.append(extraRegex);
        }
        return resualt.toString();
    }
}
