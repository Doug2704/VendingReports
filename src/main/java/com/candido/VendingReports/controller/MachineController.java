package com.candido.VendingReports.controller;

import com.candido.VendingReports.entities.Machine;
import com.candido.VendingReports.services.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/machines")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService service;

    @GetMapping("/{id}")
    public ResponseEntity<Machine> findById(@PathVariable Long id) {
        Optional<Machine> machine = service.findById(id);
        if (machine.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(machine.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Machine>> findAll() {
        List<Machine> machines = service.findAll();
        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Machine> create(@RequestBody Machine machine) {
        Machine m = service.create(machine);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> update(@RequestBody Machine machine, @PathVariable Long id) {
        Optional<Machine> findById = service.findById(id);
        Machine m;
        if (findById.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        m = findById.get();
        m.setCode(machine.getCode());
        m.setClient(machine.getClient());
        m.setProducts(machine.getProducts());
        m.setTotal(m.getTotal());
        m.setAudit03(m.getAudit03());
        m.setAudit08(m.getAudit08());
        m.setAudit09(m.getAudit09());
        Machine update = service.update(m);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

}
