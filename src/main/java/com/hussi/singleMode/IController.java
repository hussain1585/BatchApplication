package com.hussi.singleMode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;

/**
 * The IController interface defines a contract for a controller that handles decoding requests. It
 * provides a method to decode a given input and return the decoded output wrapped in a
 * ResponseEntity.
 *
 * @param <I> the type of the input parameter
 * @param <O> the type of the output parameter
 */
public interface IController<I, O> {
  // I -> input
  // O -> output
  @GetMapping("/decode")
  CompletableFuture<ResponseEntity<O>> decode(@RequestParam I vin, @RequestParam I countryFlag);

  @GetMapping("/decodeForVhr")
  CompletableFuture<ResponseEntity<O>> decodeForVhr(@RequestParam I vin, @RequestParam I countryFlag);
}
