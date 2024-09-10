package com.candido.VendingReports.repositories;

import com.candido.VendingReports.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
