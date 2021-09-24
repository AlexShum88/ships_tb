package com.shum.ships_tb.service.port;

import com.shum.ships_tb.repository.PortRepository;
import com.shum.ships_tb.repository.entity.RepoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortImpl implements IPort{
    private final PortRepository portRepository;

    @Autowired
    public PortImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public List<RepoPort> findAll() {
        return portRepository.findAll();
    }
}
