package tanzu.newsletter.subscription;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tanzu.newsletter.subscription.controller.SubscriptionController;
import tanzu.newsletter.subscription.exception.ResourceConflictException;
import tanzu.newsletter.subscription.repository.SubscriptionRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import tanzu.newsletter.subscription.model.Subscription;
import tanzu.newsletter.subscription.service.SubscriptionService;

import java.util.List;

// mvn test -Dspring.profiles.active=test

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubscriptionControllerTest {
	private static StringBuilder output = new StringBuilder("");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	private SubscriptionController controller;


	@Test
	@Order(1)
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/api/v1/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}


	/**
	 * Create a new Subscription by passing a JSON object with firstName,
	 * lastName and emailId
	 *
	 * @result      The application should create a new Subscription and automaticly generated a new Id
	 */
	@Test
	@Order(2)
	public void testCreateSubscription() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/subscription")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"emailId\": \"john.doe@example.com\" }"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.emailId").value("john.doe@example.com"))
				.andDo(print());
	}

	/**
	 * Create a new Subscription by passing a JSON object with firstName, lastName and emailId
	 * @result The application should creat a ResourceConflictException as the same opbject alreada
	 * exist in the database
	 */
	@Test
	@Order(3)
	public void testCreateSubscriptionAgain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/subscription")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"emailId\": \"john.doe@example.com\" }"))
				.andExpect(status().isConflict())
				.andDo(MockMvcResultHandlers.print())
				.andDo(print());
	}

	/**
	 * testGetSubscriptionByIdFound - Get a Subscription by Id
	 * @result The request should return a JSON object containing the found Subscription
	 */
	@Test
	@Order(4)
	public void testGetSubscriptionByIdFound() throws Exception {
		long id = 1;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/1"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.emailId").value("john.doe@example.com"))
				.andDo(print());
	}


	/**
	 * testGetSubscriptionByIdNotFound - Try to get a Subscription by Id that does not exist
	 * @result The request should result in a ResourceNotFoundException with status code 404 and with a customized messsage
	 * Subscription with id: xyz does not exist.
	 */
	@Test
	@Order(5)
	public void testGetSubscriptionByIdNotFound() throws Exception {
		long id = 9999;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/" + id))
				.andExpect(status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Subscription with id: 9999 not found."))
				.andDo(print());
	}

	/**
	 * testUpdateSubscriptionUpdate - Update Subscription by Id
	 * @result The request should be a modified Subscription Object
	 */
	@Test
	@Order(6)
	public void testUpdateSubscriptionUpdate() throws Exception {
		String email = "john.doe@example.com";
		long id = 0;

		// Verify if email address is already registered
		List<Subscription> subscription_list = subscriptionRepository.findAll();
		for(Subscription item:subscription_list){
			if (item.getEmailId().contains(email)) {
				id = item.getId();
			}
		}

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/subscription/" + id)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"firstName\": \"John Gerald\", \"lastName\": \"Doe\", \"emailId\": \"john.doe@example.com\" }"))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andDo(print());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/" +id))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John Gerald"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.emailId").value("john.doe@example.com"))
				.andDo(print());
	}


	/**
	 * testDeleteSubscription - Delete Subscription by Id
	 * @result The request should be a modified Subscription Object
	 */
	@Test
	@Order(7)
	public void testDeleteSubscription() throws Exception {
		String email = "john.doe@example.com";
		long id = 0;

		// Verify if email address is already registered
		List<Subscription> subscription_list = subscriptionRepository.findAll();
		for(Subscription item:subscription_list){
			if (item.getEmailId().contains(email)) {
				id = item.getId();
			}
		}

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/subscription/" + id))
				.andExpect(status().isOk())
				.andDo(print());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/" +id))
				.andExpect(status().isNotFound())
				.andDo(print());
	}

	/**
	 * testCreateMultipleSubscriptions - Create a bulk of new Subscription by passing a JSON array object with firstName, lastName and emailId
	 * @result The application should create a new Subscription and automaticly generated a new Id
	 */
	@Test
	@Order(8)
	public void testCreateMultipleSubscriptions1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/subscriptions")
						.contentType(MediaType.APPLICATION_JSON)
						.content("[{ \"firstName\": \"Peter\", \"lastName\": \"Doe\", \"emailId\": \"peter.doe@example.com\" }, { \"firstName\": \"James\", \"lastName\": \"Doe\", \"emailId\": \"james.doe@example.com\" }]"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Peter"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].emailId").value("peter.doe@example.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("James"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].emailId").value("james.doe@example.com"))
				.andDo(print());
	}





	/**
	 * testGetAllSubscriptions - Get a Subscription by Id that exists
	 * @result The request should return a JSON object containing the found Subscription
	 */
	@Test
	@Order(9)
	public void testGetAllSubscriptions() throws Exception {
		/*
		Subscription subscription = new Subscription();
		subscription.setFirstName("John");
		subscription.setLastName("Doe");
		subscription.setEmailId("john.doe@example.com");
		subscriptionRepository.save(subscription);
		 */

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscriptions"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Peter"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].emailId").value("peter.doe@example.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("James"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].emailId").value("james.doe@example.com"))
				.andDo(print());
	}




	/**
	 * testGetSubscriptionByIdFound - Get a Subscription by Id that exists
	 * @result The request should return a JSON object containing the found Subscription
	 */

	/*
	@Test
	public void testGetSubscriptionByIdFound1() throws Exception {
		Subscription subscription = new Subscription();
		subscription.setFirstName("Jane");
		subscription.setLastName("Doe");
		subscription.setEmailId("jane.doe@example.com");
		subscription = subscriptionRepository.save(subscription);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/" + subscription.getId()))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Jane"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.emailId").value("jane.doe@example.com"))
				.andDo(print());
	}

	 */


	/**
	 * Try to get a Subscription by Id that does not exist
	 * @result The request should result in a ResourceNotFoundException with status code 404 and with a customized messsage
	 *         "Subscription with id: xyz does not exist.
	 */

	/*
	@Test
	public void testGetSubscriptionByIdNotFound1() throws Exception {
		long badId = 9999;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/subscription/" + badId))
				.andExpect(status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Subscription with id: 9999 does not exist."))
				.andDo(print());
	}

	 */

}
