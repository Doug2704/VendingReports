package com.candido.VendingReports.services;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.repositories.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final MachineRepository repository;

    public Machine findById(Long id) {
        Optional<Machine> machine = repository.findById(id);
        if (machine.isEmpty()) {
            return new Machine();
        }
        return machine.get();
    }

    public List<Machine> findAll() {
        return repository.findAll();
    }

    public Machine create(Machine machine) {
        return repository.save(machine);
    }
}
