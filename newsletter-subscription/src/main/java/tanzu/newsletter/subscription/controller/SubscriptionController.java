package tanzu.newsletter.subscription.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

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

import tanzu.newsletter.subscription.exception.ResourceConflictException;
import tanzu.newsletter.subscription.exception.ResourceNotFoundException;
import tanzu.newsletter.subscription.model.Subscription;
import tanzu.newsletter.subscription.repository.SubscriptionRepository;

@OpenAPIDefinition(info = @Info(title = "Newsletter Application", version = "1.0"), tags = @Tag(name = "Subscription Profile Management (Rest CRUD API)"))

@Schema(required = true, example = "1111111")

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class SubscriptionController {
        @Autowired
        private SubscriptionRepository subscriptionRepository;

        // get all subscriptions
        @Operation(summary = "Get all subscription profiles registered.", method = "GET", tags = "Array of Subscription Profiles")
        //@Parameter(description = "domain name")
        //@Parameter(description = "domain extension")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200", 
                        description = "Subscription profiles retrieved successfully.", 
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class), 
                                mediaType = "application/json"
                        ), 
                        headers = {
                                @Header(
                                        name = "id", 
                                        description = "A ascending uniq Id beginning from 1. This Id can be used to identify a record.", 
                                        required = true, 
                                        schema = @Schema(type = "integer")
                                ),
                                @Header(
                                        name = "first_name", 
                                        description = "First Name of the user requesting a newsletter subscriptions", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "last_name", 
                                        description = "Last Name of the user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "email_id", 
                                        description = "Email address of tssdhe user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                )
                        }
                ),
                @ApiResponse(
                        responseCode = "404", 
                        description = "No ubscription profiles found.", 
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class),
                                examples = { @ExampleObject(
                                        value = "{ \"timestamp\":\"2023-04-13T19:42:38.918+00:00\", \"status\":\"404\", \"error\":\"Not Found\", \"path\":\"/api/v1/subscription\" }")
                                }, 
                                mediaType = "application/json"
                        )
                )
        })

        @CrossOrigin
        @GetMapping("/subscriptions")
        public List<Subscription> getAllSubscription() {
                System.out.println("HTTP-GET-2: /api/subscriptions hallo");

                return subscriptionRepository.findAll();
        }

        /* #JRA-411 - DELETE ALL SUBSCRIPTIONS */
        /*
        @Operation(summary = "Delete all subscription profiles", method = "DELETE", tags = "Array of Subscription Profiles")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "201",
                        description = "All Ssubscription profiles successfully deleted.",
                        content = @Content(schema = @Schema(implementation = Subscription.class), mediaType="application/json")
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Subscription profile not found.",
                        content=@Content(schema=@Schema(implementation=Subscription.class), mediaType="application/json")
                )
        })

        @CrossOrigin
        @DeleteMapping("/subscriptions")
        public ResponseEntity<Map<String, Boolean>> deletetAllSubscription(){
                System.out.println("HTTP-DELETE: /api/subscriptions");

                // Verify if email address is already registered
                List<Subscription> subscriptionList = subscriptionRepository.findAll();
                for (Subscription item : subscriptionList) {
                        System.out.println("HTTP-DELETE: Debug: " + item.getEmailId());
                        System.out.println("HTTP-DELETE-TEST-1: Debug: " + item.getEmailId());
                        System.out.println("XXXXX HTTP-DELETE-TEST-1: Debug: " + item.getEmailId());
                        //subscriptionRepository.delete(item);
                }

                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);

                return ResponseEntity.ok(response);
        }
        */

        @Operation(summary = "Saves a provided subscription profiles.", method = "POST", tags = "Subscription Profile")
        @ApiResponses({ 
                @ApiResponse(
                        responseCode = "201",
                        description="User's subscription profile successfully saved.",
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class), 
                                mediaType="application/json",
                                examples = {
                                        @ExampleObject(
                                                name = "createSubscription", 
						summary = "Add subscription profile.", 
						description = "RSubmitts a Newsletter subscription profils.", 
                                                value = "[{ \"emailId\":\"frank@example.com\", \"firstName\":\"Frank\", \"lastName\":\"Zappa\"}]"
                                        )
                                }
                        ),
                        headers = {
                                @Header(
                                        name = "id",
                                        description = "A ascending uniq Id beginning from 1. This Id can be used to identify a record.",
                                        required = true,
                                        schema = @Schema(type = "integer")
                                ),
                                @Header(
                                        name = "first_name",
                                        description = "First Name of the user requesting a newsletter subscriptions",
                                        required = false,
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "last_name",
                                        description = "Last Name of the user requesting a newsletter subscriptions.",
                                        required = false,
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "email_id",
                                        description = "Email address of the user requesting a newsletter subscriptions.",
                                        required = false,
                                        schema = @Schema(type = "string")
                                )
                        }
                )
	})

        @CrossOrigin
        @PostMapping("/subscription")
        public Subscription createSubscription(@RequestBody Subscription subscription) {
                /* GAGA */
                System.out.println("HTTP-POST Subscription (/api/subscription)");
                System.out.println(" - Input: subscription is an array: "+subscription.getClass().isArray());System.out.println(" - Input: subscription is an isEnum: "+subscription.getClass().isEnum());System.out.println(" - Input: subscription is a Member Class: "+subscription.getClass().isMemberClass());System.out.println(" - Input: subscription is a Local Class: "+subscription.getClass().isLocalClass());

                System.out.println("xxx: "+ResponseEntity.ok(subscription));

                System.out.println("subscription{}");System.out.println("    - Element: "+subscription.getEmailId());System.out.println("    - Element: "+subscription.getFirstName());System.out.println("    - Element: "+subscription.getLastName());System.out.println("    - Element: "+subscription.getId());System.out.println("bla    - Element: "+subscription.getId());

                // Verify if email address is already registered
                List<Subscription> subscription_list = subscriptionRepository.findAll();for(
                Subscription item:subscription_list){
                        if (item.getEmailId().contains(subscription.getEmailId())) {
                                throw new ResourceConflictException("Email " + subscription.getEmailId() + " already registered");
                        }
                }

                return subscriptionRepository.save(subscription);
        }

        @Operation(summary = "Saves a provided array of subscription profiles.", method = "POST", tags = "Array of Subscription Profiles")
        @ApiResponses({
		@ApiResponse(
			responseCode = "200", 
			description = "User's test subscription profile successfully saved.", 
			content = @Content(
				array = @ArraySchema(schema = @Schema(implementation = Subscription.class)), 
				mediaType = "application/json", 
				examples = {
					@ExampleObject(
						name = "createSubscriptionArray", 
						summary = "Add array of subscription profiles.", 
						description = "Submitts an array of Newsletter subscription profiles.", 
                                                value = "[{ \"emailId\":\"john@example.com\", \"firstName\":\"John\", \"lastName\":\"Fogerty\"}, { \"emailId\":\"frank@example.com\", \"firstName\":\"Frank\", \"lastName\":\"Zappa\"}, {\"emailId\":\"bob@example.com\", \"firstName\":\"Bob\", \"lastName\":\"Seger\"}]"
                                        ),
					@ExampleObject(name = "createSubscription", 
						summary = "Add subscription profile.", 
						description = "RSubmitts a Newsletter subscription profils.", 
                                                value = "[{ \"emailId\":\"frank@example.com\", \"firstName\":\"Frank\", \"lastName\":\"Zappa\"}]"
                                        )
				}
			), 
			headers = {
				@Header(
					name = "id", 
					description = "A ascending uniq Id beginning from 1. This Id can be used to identify a record.", 
					required = true, 
					schema = @Schema(type = "integer")
				),
				@Header(
					name = "first_name", 
					description = "First Name of the user requesting a newsletter subscriptions", 
					required = false, 
					schema = @Schema(type = "string")
				),
				@Header(
					name = "last_name", 
					description = "Last Name of the user requesting a newsletter subscriptions.", 
					required = false, 
					schema = @Schema(type = "string")
				),
				@Header(
					name = "email_id", 
					description = "Email address of the user requesting a newsletter subscriptions.", 
					required = false, 
					schema = @Schema(type = "string")
				)
			}
		),
		@ApiResponse(
			responseCode = "409", 
			description = "Passed Email address is already registerd.", 
			content = @Content(schema = @Schema(implementation = Subscription.class),
                        examples = {@ExampleObject(value = "{ \"timestamp\":\"2023-04-13T19:42:38.918+00:00\", \"status\":\"409\", \"error\":\"Conflict\", \"path\":\"/api/v1/subscription\" }")}, 
			mediaType = "application/json")
		),
		@ApiResponse(
			responseCode = "408", 
			description = "Bad formated request.", 
			content = @Content(schema = @Schema(implementation = Subscription.class), 
			examples = {
				@ExampleObject(value = "{ \"timestamp\":\"2023-04-13T19:42:38.918+00:00\", \"status\":\"404\", \"error\":\"Bad Request\", \"path\":\"/api/v1/subscription\" }") }, mediaType = "application/json")
		)
        })

        @CrossOrigin
        @PostMapping("/subscriptions")
        public Subscription[] createSubscriptionArray(@RequestBody Subscription subscriptionArray[]) {
                /* GAGA */
                System.out.println("HTTP-POST Subscription Array (/api/subscriptions)");
                System.out.println("- Input: subscriptionArray is an array: " + subscriptionArray.getClass().isArray());

                for (Subscription ArrayItem : subscriptionArray) {
                        System.out.println("xxx: " + ResponseEntity.ok(ArrayItem));
                        System.out.println("subscriptionArray[]");
                        System.out.println("    - Element: " + ArrayItem.getEmailId());
                        System.out.println("    - Element: " + ArrayItem.getFirstName());
                        System.out.println("    - Element: " + ArrayItem.getLastName());

                        // Verify if email address is already registered
                        List<Subscription> subscriptionList = subscriptionRepository.findAll();
                        for (Subscription item : subscriptionList) {
                                if (item.getEmailId().contains(ArrayItem.getEmailId())) {
                                        throw new ResourceConflictException("Email " + ArrayItem.getEmailId() + " already registered");
                                }
                        }
                        subscriptionRepository.save(ArrayItem);
                }

                return subscriptionArray;
        }

        // get employee by id rest api
        @Operation(summary = "Get a subscription profils by it's Id", method = "GET", tags = "Subscription Profiles")
        @ApiResponses({
		@ApiResponse(
			responseCode = "302", 
			description = "User's subscription profile succesfound by its Id.", 
			content = @Content(
				schema = @Schema(
				implementation = Subscription.class), 
				mediaType = "application/json"
			), 
                        headers = {
                                @Header(
                                        name = "id", 
                                        description = "A ascending uniq Id beginning from 1. This Id can be used to identify a record.", 
                                        required = true, 
                                        schema = @Schema(type = "integer")
                                ),
                                @Header(
                                        name = "first_name", 
                                        description = "First Name of the user requesting a newsletter subscriptions", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "last_name", 
                                        description = "Last Name of the user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "email_id", 
                                        description = "Email address of the user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                )

                        }
                ),
                @ApiResponse(
                        responseCode = "404", 
                        description = "Subscription with the provided id not found.", 
                        content = @Content(schema = @Schema(implementation = Exception.class), 
                        mediaType = "application/json")
                )
        })

        @CrossOrigin
        @GetMapping("/subscription/{id}")
        public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
                Subscription subscription = subscriptionRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Subscription with id: " + id + "not exist."));
                return ResponseEntity.ok(subscription);
        }

        // update subscription rest api
        @Operation(summary = "Update provided user subscription profiles.", method = "PUT", tags = "Subscription Profiles")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "302", 
                        description = "User's subscription profile succesfound by its Id.", 
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class), 
                                mediaType = "application/json"
                        ), 
                        headers = {
                                @Header(
                                        name = "id", 
                                        description = "A ascending uniq Id beginning from 1. This Id can be used to identify a record.", 
                                        required = true, 
                                        schema = @Schema(type = "integer")
                                ),
                                @Header(
                                        name = "first_name", 
                                        description = "First Name of the user requesting a newsletter subscriptions", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "last_name", description = "Last Name of the user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                ),
                                @Header(
                                        name = "email_id", 
                                        description = "Email address of the user requesting a newsletter subscriptions.", 
                                        required = false, 
                                        schema = @Schema(type = "string")
                                )
                        }
                ),
                @ApiResponse(
                        responseCode = "404", 
                        description = "ubscription with the provided id not found.", 
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class),
                                examples = { @ExampleObject(
                                        value = "{ \"timestamp\":\"2023-04-13T19:42:38.918+00:00\", \"status\":\"404\", \"error\":\"Conflict\", \"path\":\"/api/v1/subscription\" }") }, 
                                mediaType = "application/json"
                        )
                )
        })

        @CrossOrigin
        @PutMapping("/subscription/{id}")
        public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id,
                        @RequestBody Subscription subscriptionDetails) {
                Subscription subscription = subscriptionRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Subscription not exist with id :" + id));

                subscription.setFirstName(subscriptionDetails.getFirstName());
                subscription.setLastName(subscriptionDetails.getLastName());
                subscription.setEmailId(subscriptionDetails.getEmailId());

                Subscription updatedSubscription = subscriptionRepository.save(subscription);
                return ResponseEntity.ok(updatedSubscription);
        }

        // delete employee rest api
        @Operation(summary = "Delete a subscription profile", method = "DELETE", tags = "Subscription Profiles")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "201", 
                        description = "Ssubscription profile successfully deleted.", 
                        content = @Content(
                                schema = @Schema(implementation = Subscription.class), 
                                examples = {@ExampleObject(
                                        name = "getUserAttribute", 
                                        summary = "Delete a subscription profile.", 
                                        description = "Delete a user's subscription profile with the provided subscription id.", 
                                        value = "{ \"deleted\":\"true\" }")
                                }, 
                                mediaType = "application/json"
                        )
                ),
                @ApiResponse(
                        responseCode = "404", 
                        description = "Subscription profile not found.", 
                                content = @Content(
                                schema = @Schema(
                                        implementation = Subscription.class), 
                                        examples = { @ExampleObject(
                                                name = "getAllSubscription", 
                                                summary = "Retrieves all user subscription registered.", 
                                                description = "Retrieves a User's attributes.", 
                                                                        value = "{ \"timestamp\":\"2023-04-13T19:42:38.918+00:00\", \"status\":\"404\", \"error\":\"Conflict\", \"path\":\"/api/v1/subscription\" }"
                                                        )
                                }, 
                                mediaType = "application/json"
                         )
                )
        })
        
        @CrossOrigin
        @DeleteMapping("/subscription/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteSubscription(
                        //@Schema(required = true, example = "32126319")
                        @Parameter(description = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable Long id) {

                Subscription subscription = subscriptionRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

                subscriptionRepository.delete(subscription);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return ResponseEntity.ok(response);
        }
}
