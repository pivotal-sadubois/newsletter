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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import tanzu.newsletter.subscription.exception.ResourceNotFoundException;
import tanzu.newsletter.subscription.model.Subscription;
import tanzu.newsletter.subscription.repository.SubscriptionRepository;

//import javax.validation.Valid;

@OpenAPIDefinition(
        info = @Info(
                title = "Subscription Management API",
                version = "1.0"),
        tags = @Tag(
                name = "Subscription Management REST API"))


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class SubscriptionController {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	// get all subscriptions
	@Operation(summary = "Get customer profile.", method = "GET", tags = "Customer Profile CRUD")
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "Customer profile retrieved successfully."
		),
		@ApiResponse(
				responseCode = "404",
				description = "Customer profile not found.",
				content = @Content(schema = @Schema(implementation = Subscription.class))
		)
	})
	@GetMapping("/subscription")
	public List<Subscription> getAllSubscription(){
		return subscriptionRepository.findAll();
	}		
	
	// create employee rest api

	
	@Operation(summary = "Saves provided customer profile.", method = "POST", tags = "Customer Profile CRUD")
	@ApiResponses({
		@ApiResponse(
				responseCode = "201",
				description = "Customer profile successfully saved.",
				headers = @Header(
						name = "Location",
						description = "Contains path which can be used to retrieve saved profile. Last element is it's ID.",
						required = true,
						schema = @Schema(type = "string"))
		),
		@ApiResponse(
				responseCode = "400",
				description = "Passed customer profile is invalid."
		)
})
	@PostMapping("/subscription")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}
	
	// get employee by id rest api
 
/* 
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "200", description = "Found the book", 
		  content = { @Content(mediaType = "application/json", 
			schema = @Schema(implementation = Book.class)) }),
		@ApiResponse(responseCode = "400", description = "Invalid id supplied", 
		  content = @Content), 
		@ApiResponse(responseCode = "404", description = "Book not found", 
		  content = @Content) })

*/
	//@Operation(summary = "Get customer profile.", method = "GET", tags = "Customer Profile CRUD")
	

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