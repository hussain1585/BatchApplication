package com.hussi.dummy.usecase;

public class QANPBatchUseCase extends BatchUseCase<String, String>{
    // I -> inputFilePath
    // O -> outputFilePath
    public String process(String inputFilePath, String countryFlag){
        return "";
    }

    @Override
    protected String downloadFile(String s3Location) {
        return null;
    }

    @Override
    protected void validateInput(String localFile) {

    }

    @Override
    protected String processBatch(String localFile) {
        return null;
    }

    @Override
    protected void validateOutput(String processedFile) {

    }

    @Override
    protected String writeOutput(String processedFile) {
        return null;
    }

    @Override
    protected void sendNotification(String outputFile) {

    }
}