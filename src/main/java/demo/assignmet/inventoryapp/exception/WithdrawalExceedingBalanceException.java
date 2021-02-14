package demo.assignmet.inventoryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SEE_OTHER,  reason = "Quantity requested exceeds current balance.")
public class WithdrawalExceedingBalanceException extends IllegalStateException {
}
