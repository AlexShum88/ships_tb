package com.shum.ships_tb.service.cargo;

import com.shum.ships_tb.repository.CargoRepository;
import com.shum.ships_tb.repository.entity.RepoCargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoImpl implements ICargo{

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<RepoCargo> findAll() {
        return cargoRepository.findAll();
    }
}
