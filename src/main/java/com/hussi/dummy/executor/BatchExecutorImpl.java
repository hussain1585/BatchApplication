package com.hussi.dummy.executor;

import com.hussi.dummy.usecase.BatchUseCase;
import com.hussi.dummy.usecase.UseCase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class BatchExecutorImpl extends BatchExecutor {
    // I -> input
    // O -> output
    // F -> function
    @Override
    public <I, O, F> CompletableFuture<F> execute(
            BatchUseCase<I, O> batchUseCase,
            I input,
            I countryFlag,
            Function<O, F> dtoToResponseMapper) {

        batchUseCase.downloadFile((String) input);
        batchUseCase.validateInput((String) input);
        batchUseCase.process((I) input, (I) countryFlag);
        batchUseCase.validateOutput((String) input);
        batchUseCase.writeOutput((String) input);
        batchUseCase.sendNotification((String) input);


        return CompletableFuture.supplyAsync(() -> input)
                .thenApplyAsync(i -> batchUseCase.process(input, countryFlag))
                .thenApplyAsync(dtoToResponseMapper);
    }

}
