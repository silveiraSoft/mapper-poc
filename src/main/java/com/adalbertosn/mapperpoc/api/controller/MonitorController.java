package com.adalbertosn.mapperpoc.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/anon")
public class MonitorController {
    @GetMapping("/monitor")
    public Mono<String> monitor() {
        return Mono.just("hello");
    }
}
