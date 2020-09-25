package com.svetikov.testplcmoor.service;

import com.svetikov.testplcmoor.model.PLC;

import java.util.List;
import java.util.Optional;

public interface PlcService {
    Optional<PLC> findPLCId(int id);
    List<PLC> allPLC();
    void savePLC (PLC plc);
    void saveAllPLC(List<PLC> list);
    void init(int id);

}
