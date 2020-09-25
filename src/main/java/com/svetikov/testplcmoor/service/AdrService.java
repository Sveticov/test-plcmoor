package com.svetikov.testplcmoor.service;

import com.svetikov.testplcmoor.model.AddressPLC;
import com.svetikov.testplcmoor.repository.AdrRepository;


import java.util.List;
import java.util.Optional;

public interface AdrService {
    Optional<AddressPLC> findAddressPLCId(int id);
    List<AddressPLC> allAddressPLC();
    void savePLC (AddressPLC plc);
    void saveAllAddressPLC(List<AddressPLC> list);
}
