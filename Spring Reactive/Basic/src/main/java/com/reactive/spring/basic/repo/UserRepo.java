package com.reactive.spring.basic.repo;

import com.reactive.spring.basic.entity.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveMongoRepository<User,Integer> {
    @Query(value = "{name: ?0}")
    @Aggregation
    Flux<User> findByName(String name);
    @Query(value = "{$where: 'this.mobile && this.mobile.length === 10'}",sort = "{name: -1}")
    Flux<User> findByMobile();
    @Query(value = "{_id: ?0}",fields = "{name: 1,_id: 0}")
    Mono<String> findNameById(int id);
}
