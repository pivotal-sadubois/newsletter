package tanzu.newsletter.subscription.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tanzu.newsletter.subscription.exception.ResourceNotFoundException;
import tanzu.newsletter.subscription.model.Subscription;
import tanzu.newsletter.subscription.repository.SubscriptionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SubscriptionController {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	// get all employees
	@GetMapping("/subscription")
	public List<Subscription> getAllSubscription(){
		return subscriptionRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/subscription")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}
	
	// get employee by id rest api
	@GetMapping("/subscription/{id}")
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
		Subscription subscription = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription not exist with id :" + id));
		return ResponseEntity.ok(subscription);
	}
	
	// update subscription rest api
	
	@PutMapping("/subscription/{id}")
	public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id, @RequestBody Subscription subscriptionDetails){
		Subscription subscription = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription not exist with id :" + id));
		
		subscription.setFirstName(subscriptionDetails.getFirstName());
		subscription.setLastName(subscriptionDetails.getLastName());
		subscription.setEmailId(subscriptionDetails.getEmailId());
		
		Subscription updatedSubscription = subscriptionRepository.save(subscription);
		return ResponseEntity.ok(updatedSubscription);
	}
	
	// delete employee rest api
	@DeleteMapping("/subscription/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSubscription(@PathVariable Long id){
		Subscription subscription = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		subscriptionRepository.delete(subscription);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}