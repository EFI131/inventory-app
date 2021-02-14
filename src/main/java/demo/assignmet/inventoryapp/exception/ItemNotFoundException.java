package demo.assignmet.inventoryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO: A MORE GENERIC EXCEPTION HANDLER
@ResponseStatus(value = HttpStatus.NOT_FOUND,  reason = "ID Provided didn't match any item.")
public class ItemNotFoundException extends RuntimeException{
}
