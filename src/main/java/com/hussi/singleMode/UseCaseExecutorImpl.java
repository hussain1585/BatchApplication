package com.experian.evd.read.application;

import com.hussi.singleMode.UseCase;
import com.hussi.singleMode.UseCaseExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor {

    // I -> String
    // O -> DecodedPojo
    // F -> Function to map O to ResponseEntity<O>
    @Override
    public <I, O, F> CompletableFuture<F> execute(
            UseCase<I, O> useCase, I input, I countryFlag, Function<O, F> dtoToResponseWrapper) {
        return CompletableFuture.supplyAsync(() -> input)
                .thenApplyAsync(i -> useCase.execute(i, countryFlag))
                .thenApplyAsync(dtoToResponseWrapper);
    }

}
