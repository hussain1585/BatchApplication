package com.hussi.dummy.executor;

import com.hussi.dummy.usecase.BatchUseCase;
import com.hussi.dummy.usecase.UseCase;

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


//    public final void run(String s3Location) {
//        String localFile = downloadFile(s3Location); // Stage 2
//        validateInput(localFile);                   // Stage 3
//        String processedFile = processBatch(localFile); // Stage 4
//        validateOutput(processedFile);              // Stage 5
//        String outputFile = writeOutput(processedFile); // Stage 6
//        sendNotification(outputFile);               // Stage 7
//    }
//
//    protected abstract String downloadFile(String s3Location);
//    protected abstract void validateInput(String localFile);
//    protected abstract String processBatch(String localFile);
//    protected abstract void validateOutput(String processedFile);
//    protected abstract String writeOutput(String processedFile);
//    protected abstract void sendNotification(String outputFile);
}
