
package com.gestion.clientes.controller;

import com.gestion.clientes.exception.ResourceNotFoundException;
import com.gestion.clientes.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.clientes.repository.ClienteRepository;
import jakarta.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Emanuel
 */

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/api/v1")

public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @GetMapping("/cliente")
    private List<Cliente> ListarClientes(){
        return clienteRepository.findAll();
    }
    
    @PostMapping("/cliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return  clienteRepository.save(cliente);
    }
    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> listarClientePorId(@PathVariable Long id){
    
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese id no existe :" + id));
        return ResponseEntity.ok(cliente);
    }
 
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteRequest){
       Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese id no existe :" + id));
       
       cliente.setNombre(clienteRequest.getNombre());
       cliente.setApellido(clienteRequest.getApellido());
       cliente.setEmail(clienteRequest.getEmail());
       
       Cliente clienteActualizado = clienteRepository.save(cliente);
       
       return ResponseEntity.ok(clienteActualizado);
       
    }
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese id no existe :" + id));
        
        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        
        return ResponseEntity.ok(response);
    }
    
    
}
