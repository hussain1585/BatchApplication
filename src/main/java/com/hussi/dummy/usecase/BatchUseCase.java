package com.hussi.dummy.usecase;

public abstract class BatchUseCase<I,O>{
    // I -> inputFilePath
    // O -> output
    public abstract O process(I input, I countryFlag);

    //    public final void run(String s3Location) {
//        String localFile = downloadFile(s3Location); // Stage 2
//        validateInput(localFile);                   // Stage 3
//        String processedFile = processBatch(localFile); // Stage 4
//        validateOutput(processedFile);              // Stage 5
//        String outputFile = writeOutput(processedFile); // Stage 6
//        sendNotification(outputFile);               // Stage 7
//    }
//
    public abstract String downloadFile(String s3Location);
    public abstract void validateInput(String localFile);
    public abstract String processBatch(String localFile);
    public abstract void validateOutput(String processedFile);
    public abstract String writeOutput(String processedFile);
    public abstract void sendNotification(String outputFile);
}