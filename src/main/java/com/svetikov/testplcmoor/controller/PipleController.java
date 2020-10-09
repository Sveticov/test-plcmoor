package com.svetikov.testplcmoor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/piple")
public class PipleController {

    @PostMapping("/create")
    public ResponseEntity<Piple> create(@RequestBody Piple piple){
        log.info(piple.toString());
        return  ResponseEntity.ok(piple);
    }
}
