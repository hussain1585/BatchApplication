package com.hussi.batchMode.executor;

import com.hussi.batchMode.IBatchScenario;
import com.hussi.batchMode.BatchContext;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EvdBatchExecutor<I, O, F> implements IBatchExecutor<I, O, F> {

    @Override
    public CompletableFuture<BatchContext<I, O, F>> execute(IBatchScenario<I, O, F> scenario) {
        return CompletableFuture.supplyAsync(() -> {
            BatchContext<I, O, F> context = new BatchContext<>();
            context = scenario.downloadInputFile(context, "s3InputPath");

            List<List<I>> chunks = context.getInputChunks();
            for (int i = 0; i < chunks.size(); i++) {
                System.out.println("Processing chunk " + (i + 1) + "/" + chunks.size());
                context.setInputs(chunks.get(i));
                context.setCurrentChunkIndex(i);

                context = scenario.validateInput(context);
                context = scenario.processBatch(context, "US");
                context = scenario.validateOutput(context);
                context = scenario.convertToTemplate(context);
                context = scenario.writeToFile(context);
                context = scenario.uploadFileToS3(context, "s3OutputPath/chunk_" + i);
            }

            context = scenario.sendNotification(context);
            context = scenario.cleanUpTempFiles(context);
            context = scenario.shutdown(context);
            return context;
        });
    }

}

// how to call it from main method
// EvdBatchExecutor<String, String, File> executor = new EvdBatchExecutor<>();
// DBANPBatch batch = new DBANPBatch();
// CompletableFuture<BatchContext<String, String, File>> future = executor.execute(batch);

// future.thenAccept(context -> {
//     // handle results, e.g. check validation errors, etc.
//     System.out.println("Batch completed!");
// });