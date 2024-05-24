package tanzu.newsletter.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tanzu.newsletter.subscription.exception.ResourceNotFoundException;
import tanzu.newsletter.subscription.exception.SubscriptionErrorResponse;
import tanzu.newsletter.subscription.model.Subscription;
import tanzu.newsletter.subscription.repository.SubscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	public SubscriptionServiceImpl(SubscriptionRepository theEmployeeRepository) {
		subscriptionRepository = theEmployeeRepository;
	}

	@Override
	public List<Subscription> findAll() {
		return subscriptionRepository.findAllByOrderByLastNameAsc();
	}

	/**
	 * This method find a Subscription by Id a wrapper methode for the JPA
	 * subscriptionRepository findById method to create an exception
	 * ResourceNotFoundException if the object could not be found.
	 *
	 * @param    theId Subscription id (must not ne null)
	 *                 the tool tip is turned off for this component.
	 * @return:        The Subscription object with the given Id
	 * @throws:        ResourceNotFoundException
	 */
	@Override
	public Subscription findById(long theId) {
		// Return an empty object if nothing could be found
		//return subscriptionRepository.findById(theId).orElse(null);

		Optional<Subscription> result = subscriptionRepository.findById(theId);
		Subscription subscription = null;

		if (result.isPresent()) {
			subscription = result.get();
		}
		else {
			// we didn't find the subscription
			System.out.println("XXXXXXXX findById Message: " + "Subscription with id: " + theId + " does not exist.");

			throw new ResourceNotFoundException("Subscription with id: " + theId + " not found.");
		}

		return subscription;
	}



	@Override
	public Subscription save(Subscription theEmployee) {
		return subscriptionRepository.save(theEmployee);
	}

	@Override
	public void deleteById(long theId) {
		subscriptionRepository.deleteById(theId);
	}
}
