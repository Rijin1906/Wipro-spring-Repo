package com.wipro.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wipro.model.Greeting;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

	
//	GET/hello
  public Mono<ServerResponse> hello(ServerRequest request) {
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
  }
}
