package com.svetikov.testplcmoor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plc")
public class PLC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAdr;
    private String namePLC;
    private boolean statusPLC;

    public PLC(String namePLC) {
        this.namePLC=namePLC;
    }
}
