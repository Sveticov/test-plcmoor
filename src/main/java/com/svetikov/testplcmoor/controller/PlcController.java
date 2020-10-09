package com.svetikov.testplcmoor.controller;

import com.svetikov.testplcmoor.model.AddressPLC;
import com.svetikov.testplcmoor.model.PLC;
import com.svetikov.testplcmoor.service.AdrService;
import com.svetikov.testplcmoor.service.PlcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlcController {

    private final PlcService plcService;
    private final AdrService adrService;

    public PlcController(PlcService plcService, AdrService adrService) {
        this.plcService = plcService;
        this.adrService = adrService;
    }

    @GetMapping("/all")
    public List<PLC> all(){
        return plcService.allPLC();
    }
    @DeleteMapping("/delete")
    public Boolean deletePLC(@RequestBody PLC plc){
        return plcService.deletePLC(plc);
    }

    @GetMapping("/alladr")
    public List<AddressPLC> adrList(){
        return adrService.allAddressPLC();
        
    }

    @GetMapping("/init/{id}")
    public void init(@PathVariable int id){
        plcService.init(id);
    }


    @PostMapping("/create")
    public PLC addPLC(@RequestBody PLC plc){
        plcService.savePLC(plc);
        return plc;
    }

    @PostMapping("/addadr")
    public AddressPLC addAdr(@RequestBody AddressPLC addressPLC){
        adrService.savePLC(addressPLC);
        return addressPLC;
    }
}
