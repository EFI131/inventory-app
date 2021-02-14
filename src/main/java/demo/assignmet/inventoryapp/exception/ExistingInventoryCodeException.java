package demo.assignmet.inventoryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SEE_OTHER,  reason = "Inventory code already exists.")
public class ExistingInventoryCodeException extends IllegalStateException{
}
