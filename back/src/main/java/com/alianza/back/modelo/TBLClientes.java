package com.alianza.back.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="TBL_Clientes")

public class TBLClientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_Cliente")
    private Integer pkCliente;
    @Column(name = "AL_SharedKey")
    @CsvBindByName
    private String alSharedKey;
    @Column(name = "AL_BusinessId")
    @CsvBindByName
    private String alBusinessId;
    @Column(name = "AL_Email")
    @CsvBindByName
    private String alEmail;
    @Column(name = "AL_Phone")
    @CsvBindByName
    private String alPhone;
    @Column(name = "AL_DateAdded")
    @CsvBindByName
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date alDateAdded;

    public  void createSharedKey(){
        String[] palabras=alBusinessId.split(" ");
        if (palabras.length>=2) {
            this.alSharedKey = (palabras[0].charAt(0) + palabras[1]);
        } else {
            this.alSharedKey = alBusinessId;
        }
    }
}


