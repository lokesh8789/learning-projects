package com.reactive.spring.basic.controller;

import com.reactive.spring.basic.entity.User;
import com.reactive.spring.basic.service.UserService;
import io.netty.channel.EventLoop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.server.HttpServerRequest;
import reactor.util.context.Context;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping(value = "/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<User> getSingleUser(@PathVariable int id) {
        return userService.getSingleUser(id);
    }
    @GetMapping(value = "/",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<User> getAllUsers() {
        return userService.getAllUsers().delayElements(Duration.ofSeconds(1)).log();
    }
    @GetMapping(value = "/user/{name}",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<User> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/int",produces = MediaType.APPLICATION_NDJSON_VALUE)
    Flux<Integer> getInt() {
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(2));
    }

    @GetMapping(value = "/user")
    Flux<User> getUserByMobile(@RequestParam String mobile) {
        log.info("/user/{mobile} API Triggered");
        return userService.getUserByMobile(mobile);
    }

    @GetMapping
    Mono<String> findNameById(@RequestParam int id) {
        return userService.findNameById(id);
    }

    @GetMapping("/future")
    public Mono<String> future(ServerWebExchange exchange) {
        log.info("Current Thread: {}", Thread.currentThread().getName());
        return Mono.fromFuture(this::getFuture)
                .doOnNext(s -> log.info("future value is {}", s));
    }

    CompletableFuture<String> getFuture() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Future Thread is : {}", Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.info("Error");
                Thread.currentThread().interrupt();
            }
            log.info("Sleep Future Thread is : {}", Thread.currentThread().getName());
            return "Sleep Successfull";
        });
    }

}
