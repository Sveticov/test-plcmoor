package com.svetikov.testplcmoor.repository;

import com.svetikov.testplcmoor.model.PLC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlcRepository extends JpaRepository<PLC,Integer> {
}
