package com.hussi.dummy.executor;

import com.hussi.dummy.usecase.BatchUseCase;
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

//        batchUseCase.downloadFile((String) input);
//        batchUseCase.validateInput((String) input);
//        batchUseCase.processBatch((I) input, (I) countryFlag);
//        batchUseCase.validateOutput((String) input);
//        batchUseCase.writeOutput((String) input);
//        batchUseCase.sendNotification((String) input);
//        return CompletableFuture.supplyAsync(() -> input)
//                .thenApplyAsync(i -> batchUseCase.process(input, countryFlag))
//                .thenApplyAsync(dtoToResponseMapper);

//        return CompletableFuture.supplyAsync(() -> {
//            String localFile = batchUseCase.downloadFile((String) input);   // Stage 2
//            batchUseCase.validateInput(localFile);                          // Stage 3
//            O processed = batchUseCase.processBatch(input, countryFlag); // Stage 4
//            batchUseCase.validateOutput((String) processed);                // Stage 5
//            String outputFile = batchUseCase.writeOutput((String) processed); // Stage 6
//            batchUseCase.sendNotification(outputFile);                      // Stage 7
//            return processed;
//        }).thenApplyAsync(dtoToResponseMapper);

//        return CompletableFuture.supplyAsync(() -> batchUseCase.downloadFile((String) input)) // Stage 2
//                .thenApplyAsync(localFile -> {
//                    batchUseCase.validateInput(localFile); // Stage 3
//                    return localFile;
//                })
//                .thenApplyAsync(localFile -> batchUseCase.processBatch(input, countryFlag)) // Stage 4
//                .thenApplyAsync(processed -> {
//                    batchUseCase.validateOutput((String) processed); // Stage 5
//                    return processed;
//                })
//                .thenApplyAsync(processed -> {
//                    String outputFile = batchUseCase.writeOutput((String) processed); // Stage 6
//                    batchUseCase.sendNotification(outputFile); // Stage 7
//                    return processed;
//                })
//                .thenApplyAsync(dtoToResponseMapper); // Final mapping

        return CompletableFuture
                .supplyAsync(batchUseCase::downloadFile)
                .thenApplyAsync(batchUseCase::validateInput )
                .thenApplyAsync(batchUseCase::processBatch)
                .thenApplyAsync(batchUseCase::writeOutput)
                .thenApplyAsync(batchUseCase::validateOutput)
                .thenApplyAsync(batchUseCase::sendNotification);

//        return CompletableFuture
//                .supplyAsync(() -> batchUseCase.downloadFile((String) input)) // Stage 2
//                .thenApplyAsync(localFile -> { batchUseCase.validateInput(localFile); return localFile; }) // Stage 3
//                .thenApplyAsync(localFile -> batchUseCase.processBatch(input, countryFlag)) // Stage 4
//                .thenApplyAsync(processed -> { batchUseCase.validateOutput((String) processed); return processed; }) // Stage 5
//                .thenApplyAsync(processed -> { batchUseCase.sendNotification(batchUseCase.writeOutput((String) processed)); return processed; }) // Stage 6 & 7
//                .thenApplyAsync(dtoToResponseMapper);
    }
}
