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
    public ResponseEntity<Machine> findById(@PathVariable Long id){
        Machine machine = service.findById(id);
        return new ResponseEntity<>(machine, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Machine>> findAll() {
        List<Machine> machines = service.findAll();
        return new ResponseEntity<>(machines, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Machine> create(@RequestBody Machine machine) {
        Machine m = service.create(machine);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }
}
