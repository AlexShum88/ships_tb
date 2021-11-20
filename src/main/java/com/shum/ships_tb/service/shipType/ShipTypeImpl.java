package com.shum.ships_tb.service.shipType;

import com.shum.ships_tb.repository.ShipTypeRepository;
import com.shum.ships_tb.repository.entity.RepoShipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShipTypeImpl implements IshipType{
    private final ShipTypeRepository shipTypeRepository;
    @Autowired
    public ShipTypeImpl(ShipTypeRepository shipTypeRepository) {
        this.shipTypeRepository = shipTypeRepository;
    }

    @Override
    public List<RepoShipType> findAll() {
        return shipTypeRepository.findAll();
    }

    @Override
    public RepoShipType findByName(String name) {
        for(RepoShipType rsh:findAll()){
            if(rsh.getPressetName().equals(name)) return rsh;
        }
        return null;
    }

}
