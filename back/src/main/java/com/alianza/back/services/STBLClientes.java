package com.alianza.back.services;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alianza.back.modelo.TBLClientes;
import com.alianza.back.repository.RTBLClientes;

@Service
public class STBLClientes {

    private static final Logger logger = LoggerFactory.getLogger(STBLClientes.class);

    @Autowired
    private RTBLClientes rtblClientes;
    @Transactional(readOnly = true)
    public List<TBLClientes> findClientes(){
        try {
            return rtblClientes.findAll();
        } catch (Exception e) {
            logger.error("Excepcion", e);
            return new ArrayList<>();
        }
        
    }

    @Transactional
    public TBLClientes saveClientes(TBLClientes crearClientes){
        try {
            crearClientes.createSharedKey();
            return rtblClientes.save(crearClientes);
        } catch (Exception e) {
            logger.error("Excepcion", e);
            return new TBLClientes();
        }
        
        
    }

    

    @Transactional
    public boolean eliminarCliente(Integer id){
        try {
            rtblClientes.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("Excepcion", e);
            return false;
        } 
    }

    @Transactional(readOnly = true)
    public List<TBLClientes> filtroCliente(TBLClientes filtroCliente){
        ExampleMatcher matcher = ExampleMatcher.matching()
            .withMatcher("alSharedKey", match -> match.contains().ignoreCase())
            .withMatcher("alBusinessId", match -> match.contains().ignoreCase())
            .withMatcher("alEmail", match -> match.contains().ignoreCase())
            .withMatcher("alPhone", match -> match.contains().ignoreCase())
            .withMatcher("alDateAdded", match -> match.contains().ignoreCase());
        Example<TBLClientes> example = Example.of(filtroCliente,matcher);
        try {
            return rtblClientes.findAll(example);
        } catch (Exception e) {
            logger.error("Excepcion", e);
            return new ArrayList<>();
        }
        
    }
}
