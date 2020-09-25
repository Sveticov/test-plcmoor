package com.svetikov.testplcmoor.controller;

import com.svetikov.testplcmoor.model.PLC;
import com.svetikov.testplcmoor.service.PlcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlcController {

    private final PlcService plcService;

    public PlcController(PlcService plcService) {
        this.plcService = plcService;
    }

    @GetMapping("/all")
    public List<PLC> all(){
        return plcService.allPLC();
    }

    @GetMapping("/init/{id}")
    public void init(@PathVariable int id){
        plcService.init(id);
    }
}
