package com.svetikov.testplcmoor;

import com.svetikov.testplcmoor.model.AddressPLC;
import com.svetikov.testplcmoor.model.PLC;
import com.svetikov.testplcmoor.service.AdrService;
import com.svetikov.testplcmoor.service.PlcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
@Slf4j
@SpringBootApplication
@EnableScheduling
public class TestPlcmoorApplication implements CommandLineRunner {
    @Autowired
    PlcService plcService;
    @Autowired
    AdrService adrService;




    private List<AddressPLC> addressPLCList;
    private List<PLC> plcList;

    public static void main(String[] args) {
        SpringApplication.run(TestPlcmoorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        plcList = List.of(new PLC("plc1"), new PLC("plc2"));
        plcService.saveAllPLC(plcList);

        addressPLCList = List.of(new AddressPLC("plc1", "adr11"),
                new AddressPLC("plc1", "adr12"),
                new AddressPLC("plc2", "adr21"),
                new AddressPLC("plc2", "adr22")
                );
        adrService.saveAllAddressPLC(addressPLCList);

    }

    @Scheduled(fixedRate = 5000)
    public void taskGen(){
        if(!plcService.allPLC().isEmpty() & !adrService.allAddressPLC().isEmpty())
        plcService.allPLC().stream()
                .filter(plc->plc.isStatusPLC())
                .forEach(plc->{
                    adrService.allAddressPLC().stream()
                            .filter(adr->plc.getNamePLC().equals(adr.getNamePLC()))
                            .forEach(adr->log.info("adr: "+adr.toString()));


                });
    }
}
