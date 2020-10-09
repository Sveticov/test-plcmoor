package com.svetikov.testplcmoor.service;

import com.svetikov.testplcmoor.model.PLC;
import com.svetikov.testplcmoor.repository.PlcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServicePLC implements PlcService {
    @Autowired
    private AdrService adrService;
    private String namePLC = "none";
    private final PlcRepository plcRepository;


    public ServicePLC(PlcRepository plcRepository) {
        this.plcRepository = plcRepository;

    }

    @Override
    public Optional<PLC> findPLCId(int id) {
        return plcRepository.findById(id);
    }

    @Override
    public List<PLC> allPLC() {
        return plcRepository.findAll();
    }

    @Override
    public void savePLC(PLC plc) {
        plcRepository.save(plc);
    }

    @Override
    public void saveAllPLC(List<PLC> list) {
        plcRepository.saveAll(list);
    }

    @Override
    public void init(int id) {
        PLC plc = plcRepository.findById(id).get();
        namePLC = plc.getNamePLC();

        plc.setStatusPLC(true);
        plcRepository.save(plc);

    }

    @Override
    public Boolean deletePLC(PLC plc) {
        plcRepository.delete(plc);
        return true;
    }

//    @Scheduled(fixedRate = 5000)
//    private void taskPLC() {
//        if (!namePLC.equals("none")) {
//            adrService.allAddressPLC().stream()
//                    .filter(adr -> adr.getNamePLC().equals(namePLC))
//                    .forEach(adr -> log.info("adr: " + adr.toString()));
//        } else log.info("wait adr");
//    }
}
