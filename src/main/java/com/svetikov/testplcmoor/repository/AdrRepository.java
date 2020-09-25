package com.svetikov.testplcmoor.repository;

import com.svetikov.testplcmoor.model.AddressPLC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrRepository extends JpaRepository<AddressPLC,Integer> {
}
