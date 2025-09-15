package com.hussi.batchMode;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractBatchScenario<I, O, F> implements IBatchScenario<I, O, F> {


    public BatchContext<I, O, F> downloadInputFile(BatchContext<I, O, F> context, String s3Path) {
        System.out.println("Downloading input file...");
        List<I> allInputs = null;//loadInputsFromS3(s3Path); // Your existing logic
        context.setInputs(allInputs);

        // Chunking logic
        int chunkSize = 1_000_000;
        List<List<I>> chunks = new ArrayList<>();
        for (int i = 0; i < allInputs.size(); i += chunkSize) {
            chunks.add(allInputs.subList(i, Math.min(i + chunkSize, allInputs.size())));
        }
        context.setInputChunks(chunks);
        context.setCurrentChunkIndex(0);
        return context;
    }


    @Override
    public BatchContext<I, O, F> validateInput(BatchContext<I, O, F> context) {
        System.out.println("Validating input...");
        // ...basic validation logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> processBatch(BatchContext<I, O, F> context, String countryFlag) {
        System.out.println("Processing batch...");
        // ...process logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> validateOutput(BatchContext<I, O, F> context) {
        System.out.println("Validating output...");
        // ...output validation logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> convertToTemplate(BatchContext<I, O, F> context) {
        System.out.println("Converting to template...");
        // ...conversion logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> writeToFile(BatchContext<I, O, F> context) {
        System.out.println("Writing to file...");
        // ...file writing logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> uploadFileToS3(BatchContext<I, O, F> context, String path) {
        System.out.println("Uploading file to S3...");
        // ...upload logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> sendNotification(BatchContext<I, O, F> context) {
        System.out.println("Sending notification...");
        // ...notification logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> cleanUpTempFiles(BatchContext<I, O, F> context) {
        System.out.println("Cleaning up temp files...");
        // ...cleanup logic...
        return context;
    }

    @Override
    public BatchContext<I, O, F> shutdown(BatchContext<I, O, F> context) {
        System.out.println("Shutting down batch...");
        // ...shutdown logic...
        return context;
    }
}