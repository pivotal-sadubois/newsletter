package tanzu.newsletter.subscription.service;

import tanzu.newsletter.subscription.model.Subscription;

import java.util.List;

public interface SubscriptionService {

	List<Subscription> findAll();

	Subscription findById(long theId);

	Subscription save(Subscription subscription);

	void deleteById(long theId);
}
