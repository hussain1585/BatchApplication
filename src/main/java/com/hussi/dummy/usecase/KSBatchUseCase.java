package com.hussi.dummy.usecase;

import java.util.List;

public class KSBatchUseCase extends BatchUseCase<String, String>{
    // I -> inputFilePath
    // O -> outputFilePath
    public String process(String inputFilePath, String countryFlag){
        return "";
    }

    @Override
    public String downloadFile(String s3Location) {
        return null;
    }

    @Override
    public void validateInput(String localFile) {

    }

    @Override
    public String processBatch(String localFile) {
        return null;
    }

    @Override
    public void validateOutput(String processedFile) {

    }

    @Override
    public String writeOutput(String processedFile) {
        return null;
    }

    @Override
    public void sendNotification(String outputFile) {

    }
}