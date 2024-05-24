package tanzu.newsletter.subscription.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SubscriptionExceptionHandler {
	// Add an exception Handlewr
	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> HandleException(ResourceNotFoundException exc) {
		System.out.println("Handle Exception: StudentNotFoundException");

		// create a studenetErrorRespnse
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();

		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());

		// return a response Entty
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> HandleException(ResourceConflictException exc) {
		System.out.println("Handle Exception: StudentNotFoundException");

		// create a studenetErrorRespnse
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();

		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setTimeStamp(System.currentTimeMillis());

		// return a response Entty
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}


	// add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> HandleException(Exception exc) {
		System.out.println("Handle All remaining Exceptions: Exception");

		// create a studenetErrorRespnse
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();

		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());

		// return a response Entty
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

