package demo.assignmet.inventoryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason = "No. of items deposited must be greater than 0.")
public class InvalidTransactionArgumentException extends RuntimeException {
}
