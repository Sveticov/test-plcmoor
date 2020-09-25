package com.svetikov.testplcmoor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adr_plc")
public class AddressPLC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String namePLC;
    private String nameADR;

    public AddressPLC(String namePLC,String nameADR) {
        this.nameADR=nameADR;
        this.namePLC=namePLC;
    }
}
