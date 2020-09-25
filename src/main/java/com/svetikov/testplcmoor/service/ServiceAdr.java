package com.svetikov.testplcmoor.service;

import com.svetikov.testplcmoor.model.AddressPLC;
import com.svetikov.testplcmoor.repository.AdrRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServiceAdr implements AdrService {

    private final AdrRepository adrRepository;

    public ServiceAdr(AdrRepository adrRepository) {
        this.adrRepository = adrRepository;
    }


    @Override
    public Optional<AddressPLC> findAddressPLCId(int id) {
        return adrRepository.findById(id);
    }

    @Override
    public List<AddressPLC> allAddressPLC() {
        return adrRepository.findAll();
    }

    @Override
    public void savePLC(AddressPLC plc) {
        adrRepository.save(plc);
    }

    @Override
    public void saveAllAddressPLC(List<AddressPLC> list) {
        adrRepository.saveAll(list);
    }
}
