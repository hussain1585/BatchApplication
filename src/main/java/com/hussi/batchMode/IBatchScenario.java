package com.hussi.batchMode;

public interface IBatchScenario<I, O, F> {
    BatchContext<I, O, F> downloadInputFile(BatchContext<I, O, F> context, String s3Path);
    BatchContext<I, O, F> validateInput(BatchContext<I, O, F> context);
    BatchContext<I, O, F> processBatch(BatchContext<I, O, F> context, String countryFlag);
    BatchContext<I, O, F> validateOutput(BatchContext<I, O, F> context);
    BatchContext<I, O, F> convertToTemplate(BatchContext<I, O, F> context);
    BatchContext<I, O, F> writeToFile(BatchContext<I, O, F> context);
    BatchContext<I, O, F> uploadFileToS3(BatchContext<I, O, F> context, String path);
    BatchContext<I, O, F> sendNotification(BatchContext<I, O, F> context);
    BatchContext<I, O, F> cleanUpTempFiles(BatchContext<I, O, F> context);
    BatchContext<I, O, F> shutdown(BatchContext<I, O, F> context);
}