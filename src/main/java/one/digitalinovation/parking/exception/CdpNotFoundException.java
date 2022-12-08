package one.digitalinovation.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CdpNotFoundException extends RuntimeException {

     public CdpNotFoundException(){
         super("Resource not found");
     }

     public CdpNotFoundException(String exception){
         super(exception);
     }

}
