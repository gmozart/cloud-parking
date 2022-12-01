package one.digitalinovation.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MtpNotFoundException extends RuntimeException {

     public MtpNotFoundException(){
         super("Resource not found");
     }

     public MtpNotFoundException(String exception){
         super(exception);
     }

}
