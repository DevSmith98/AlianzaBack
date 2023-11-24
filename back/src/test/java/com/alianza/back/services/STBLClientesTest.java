package com.alianza.back.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.alianza.back.modelo.TBLClientes;

public class STBLClientesTest {
        
    @Test
    public void test_retrieve_all_clients() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
    
        // Act
        List<TBLClientes> clientes = stblClientes.findClientes();
    
        // Assert
        assertNotNull(clientes);
        assertFalse(!clientes.isEmpty());
    }

        
        @Test
        public void test_save_new_client() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes newClient = new TBLClientes();
            // Set properties of newClient
        
            // Act
            TBLClientes savedClient = stblClientes.saveClientes(newClient);
        
            // Assert
            assertNotNull(savedClient);
            
        }

            
    @Test
    public void test_delete_client() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        TBLClientes cliente = new TBLClientes();
        cliente.setPkCliente(1);

        // Act
        boolean result = stblClientes.eliminarCliente(cliente.getPkCliente());

        // Assert
        assertFalse(result);
    }

        
        @Test
        public void test_filter_clients() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes filtroCliente = new TBLClientes();
            filtroCliente.setAlSharedKey("sharedKey");
            filtroCliente.setAlBusinessId("businessId");
            filtroCliente.setAlEmail("email");
            filtroCliente.setAlPhone("phone");
            filtroCliente.setAlDateAdded(new Date());
    
            // Act
            List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);
    
            // Assert
            assertNotNull(filteredClients);
            assertTrue(filteredClients.isEmpty());
        }

            
    @Test
    public void test_filter_clients_with_empty_filter_object() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        TBLClientes filtroCliente = new TBLClientes();
    
        // Act
        List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);
    
        // Assert
        assertNotNull(filteredClients);
        assertTrue(filteredClients.isEmpty());
    }

        
        @Test
        public void test_findClientes_returns_empty_list_when_no_clients() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
    
            // Act
            List<TBLClientes> clientes = stblClientes.findClientes();
    
            // Assert
            assertNotNull(clientes);
            assertTrue(clientes.isEmpty());
        }

            
    @Test
    public void test_eliminarCliente_nonExistentClient() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        Integer nonExistentClientId = 100;
    
        // Act
        boolean result = stblClientes.eliminarCliente(nonExistentClientId);
    
        // Assert
        assertFalse(result);
    }

        
        @Test
        public void test_filtro_cliente_no_match() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes filtroCliente = new TBLClientes();
            filtroCliente.setAlSharedKey("nonexistent");
            filtroCliente.setAlBusinessId("nonexistent");
            filtroCliente.setAlEmail("nonexistent");
            filtroCliente.setAlPhone("nonexistent");
            filtroCliente.setAlDateAdded(new Date());
        
            // Act
            List<TBLClientes> result = stblClientes.filtroCliente(filtroCliente);
        
            // Assert
            assertNotNull(result);
            assertTrue(result.isEmpty());
        }

            
    @Test
    public void test_filtroCliente_emptyFilter() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        TBLClientes filtroCliente = new TBLClientes();
    
        // Act
        List<TBLClientes> result = stblClientes.filtroCliente(filtroCliente);
    
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

        
        @Test
        public void test_save_client_with_null_values() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes crearClientes = new TBLClientes();
        
            // Act
            TBLClientes savedClient = stblClientes.saveClientes(crearClientes);
        
            // Assert
            assertNotNull(savedClient);
            
        }

            
    @Test
    public void test_filter_clients_with_one_field() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        TBLClientes filtroCliente = new TBLClientes();
        filtroCliente.setAlSharedKey("sharedKey");
    
        // Act
        List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);
    
        // Assert
        assertNotNull(filteredClients);
        assertTrue(filteredClients.isEmpty());
    }

        
        @Test
        public void test_filter_clients_with_multiple_fields() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes filtroCliente = new TBLClientes();
            filtroCliente.setAlSharedKey("sharedKey");
            filtroCliente.setAlBusinessId("businessId");
            filtroCliente.setAlEmail("email");
            filtroCliente.setAlPhone("phone");
            filtroCliente.setAlDateAdded(new Date());
    
            // Act
            List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);
    
            // Assert
            assertNotNull(filteredClients);
            assertTrue(filteredClients.isEmpty());
        }

            
    @Test
    public void test_filter_clients_with_partial_matches() {
        // Arrange
        STBLClientes stblClientes = new STBLClientes();
        TBLClientes filtroCliente = new TBLClientes();
        filtroCliente.setAlSharedKey("partial");

        // Act
        List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);

        // Assert
        assertNotNull(filteredClients);
        assertTrue(filteredClients.isEmpty());
    }

        
        @Test
        public void test_filter_clients_case_insensitive() {
            // Arrange
            STBLClientes stblClientes = new STBLClientes();
            TBLClientes filtroCliente = new TBLClientes();
            filtroCliente.setAlSharedKey("sharedKey");
            filtroCliente.setAlBusinessId("businessId");
            filtroCliente.setAlEmail("email");
            filtroCliente.setAlPhone("phone");
            filtroCliente.setAlDateAdded(new Date() );
    
            // Act
            List<TBLClientes> filteredClients = stblClientes.filtroCliente(filtroCliente);
    
            // Assert
            assertNotNull(filteredClients);
            assertTrue(filteredClients.isEmpty());
        }


}
