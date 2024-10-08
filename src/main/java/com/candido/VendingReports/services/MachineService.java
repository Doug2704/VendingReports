package com.candido.VendingReports.services;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.entities.Product;
import com.candido.VendingReports.repositories.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final MachineRepository repository;

    public Optional<Machine> findById(Long id) {
        return repository.findById(id);
    }

    public List<Machine> findAll() {
        return repository.findAll();
    }

    public List<Product> products(Long id) {
        Machine m = repository.findById(id).orElseThrow(() -> new RuntimeException("Máquina não encontrada"));
        return m.getProducts();
    }

    public Machine create(Machine machine) {
        return repository.save(machine);
    }

    public Machine update(Machine machine, Long id) {
        Machine m = repository.findById(id).orElseThrow(() -> new RuntimeException("Máquina não encontrada"));

        m.setCode(machine.getCode());
        m.setClient(machine.getClient());
        m.setProducts(machine.getProducts());
        m.setTotal(m.getTotal());
        m.setAudit03(machine.getAudit03());
        m.setAudit08(machine.getAudit08());
        m.setAudit09(machine.getAudit09());

        return repository.save(m);

    }

    public void delete(Long id) {
        Machine m = repository.findById(id).get();
        repository.delete(m);
    }
}
