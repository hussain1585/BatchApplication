package com.hussi.dummy.executor;

import com.hussi.dummy.usecase.BatchUseCase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public abstract class BatchExecutor {
    // I -> input
    // O -> output
    // F -> function
    protected abstract <I,O,F> CompletableFuture<F> execute(
            BatchUseCase<I,O> batchUseCase,
            I input,
            I countryFlag,
            Function<O,F> dtoToResponseMapper
    );
}
