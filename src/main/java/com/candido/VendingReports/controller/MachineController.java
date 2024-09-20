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
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Machine> machine = service.findById(id);
        if (machine.isEmpty()) {
            return new ResponseEntity<>("Máquina não encontrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(machine.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Machine>> findAll() {
        List<Machine> machines = service.findAll();
        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> findAllProducts(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.products(id), HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Machine> create(@RequestBody Machine machine) {
        Machine m = service.create(machine);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Machine machine, @PathVariable Long id) {
        try {
            Machine update = service.update(machine, id);
            return new ResponseEntity<>(update, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Machine> findById = service.findById(id);
        if (findById.isEmpty()) {
            return new ResponseEntity<>("Máquina não encontrada", HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity("Máquina deletada", HttpStatus.OK);

    }
}
