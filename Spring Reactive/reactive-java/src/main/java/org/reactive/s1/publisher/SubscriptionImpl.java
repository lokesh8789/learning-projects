package org.reactive.s1.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private static final int MAX = 10;
    private final Faker faker;
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }


    @Override
    public void request(long requested) {
        if (isCancelled) {
            return;
        }
        log.info("requested data: {}", requested);
        for (int i = 0; i < requested && count < MAX; i++, count++) {
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX) {
            log.info("NO More data");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Cancelled");
        this.isCancelled = true;
    }
}
