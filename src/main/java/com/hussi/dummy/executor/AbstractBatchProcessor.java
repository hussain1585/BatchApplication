//package com.hussi.dummy.executor;
//
//
///*this one set the life cycle for batch*/
//public abstract class AbstractBatchProcessor {
//
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
//}
