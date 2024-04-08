
package com.gestion.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Emanuel
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    
    public ResourceNotFoundException (String message){
        super(message);
    }
    
   
}
