package com.wipro.client;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.wipro.model.Greeting;

import reactor.core.publisher.Mono;
/*
*
* The WebClient class uses reactive features, in the form of a Mono to hold the
* content of the message (returned by the getMessage method).
*/
@Component
public class GreetingClient {
 private final WebClient client;
 // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
 // We can use it to create a dedicated `WebClient` for our component.
 public GreetingClient(WebClient.Builder builder) {
   this.client = builder.baseUrl("http://localhost:9095").build();
 }
 public Mono<String> getMessage() {
   return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
       .retrieve()
       .bodyToMono(Greeting.class)
       .map(Greeting::getMessage);
 }
}
