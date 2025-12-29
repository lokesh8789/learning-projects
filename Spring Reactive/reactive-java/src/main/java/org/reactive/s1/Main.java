package org.reactive.s1;

import org.reactive.s1.publisher.PublisherImpl;
import org.reactive.s1.subscriber.SubscriberImpl;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a Publisher
        PublisherImpl publisher = new PublisherImpl();

        // Create a Subscriber
        SubscriberImpl subscriber = new SubscriberImpl();

        // Subscribe the Subscriber to the Publisher
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(5);
    }
}
