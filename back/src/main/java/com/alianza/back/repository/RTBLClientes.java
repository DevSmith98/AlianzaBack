package com.alianza.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alianza.back.modelo.TBLClientes;

public interface RTBLClientes extends JpaRepository<TBLClientes,Integer>{
    
}
