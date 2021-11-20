package com.shum.ships_tb.service.ship;

import com.shum.ships_tb.gameObj.Ship;
import com.shum.ships_tb.repository.ShipRepository;
import com.shum.ships_tb.repository.entity.RepoShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipImpl implements IShip{
    private final ShipRepository shipRepository;

    @Autowired
    public ShipImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public List<RepoShip> findByOwner(String owner) {
        return shipRepository.findByowner(owner);
    }

    @Override
    public RepoShip findById(Integer id, List<RepoShip> rp) {
        for (int i = 0; i<rp.size();i++){
            if(rp.get(i).getId()==id){
                return rp.get(i);
            }
        }
        return rp.get(0);
    }

    @Override
    public void save(Ship ship) {
        shipRepository.save(ship.getRsh());
    }

    @Override
    public RepoShip findByNameInOwner(String shName, String owner) {
        var ships =this.findByOwner(owner);
        for(RepoShip rp:ships){
            if(rp.getName().equals(shName)) return rp;
        }
        return null;
    }
}
