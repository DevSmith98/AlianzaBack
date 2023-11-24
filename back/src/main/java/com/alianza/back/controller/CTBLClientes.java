package com.alianza.back.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.back.modelo.TBLClientes;
import com.alianza.back.services.STBLClientes;
import com.opencsv.CSVWriter;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class CTBLClientes {
    @Autowired
    private STBLClientes stblClientes;

    @GetMapping("/todos")
    public List<TBLClientes> getClientes(){
        return  stblClientes.findClientes();
    }

    @PostMapping
    public TBLClientes crearCliente(@RequestBody TBLClientes crearCliente){
        return stblClientes.saveClientes(crearCliente);
    }

    @DeleteMapping("{id}")
    public String eliminarCliente(@PathVariable("id") Integer id){
        boolean eliminado = stblClientes.eliminarCliente(id);
        if (eliminado) return "Cliente Eliminado";
        else return "Error Eliminando Cliente";
    }

    @PostMapping("/filtro")
    public List<TBLClientes> getFiltro(@RequestBody TBLClientes filtroCliente){
        return stblClientes.filtroCliente(filtroCliente);
    }

    @GetMapping("/exportar")
    public void generarCsv(HttpServletResponse response) throws IOException{
        List<TBLClientes> clientes=stblClientes.findClientes();
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=archivo.csv");
        CSVWriter csvWriter = new CSVWriter(response.getWriter());
        String[] encabezados = {"alSharedKey","alBusinessId","alEmail","alPhone","alDateAdded"};
        csvWriter.writeNext(encabezados);
        for(TBLClientes cliente : clientes){
            csvWriter.writeNext(new String[]{cliente.getAlSharedKey(),cliente.getAlBusinessId(),cliente.getAlEmail(),cliente.getAlPhone(),cliente.getAlDateAdded().toString()});
        }
        csvWriter.close();
    }

}
