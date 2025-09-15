package com.hussi.singleMode;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    // I -> String
    // O -> DecodedPojo
    // F -> Function to map O to ResponseEntity<O>
    <I, O, F> CompletableFuture<F> execute(
            UseCase<I, O> useCase, I input, I countryFlag, Function<O, F> dtoToResponseWrapper);
}
