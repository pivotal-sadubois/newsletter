package tanzu.newsletter.subscription.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceConflictException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceConflictException(String message) {
		super(message);
	}
}