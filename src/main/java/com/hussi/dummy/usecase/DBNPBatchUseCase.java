package com.hussi.dummy.usecase;

import com.hussi.enums.BatchType;

import java.util.List;
import java.util.stream.Stream;

public class DBNPBatchUseCase extends BatchUseCase<String, String>{

    @Override
    public Stream<List<String>> downloadFileInChunks(String s3Location, int chunkSize) {
        return null;
    }

    @Override
    public List<String> validateInputChunk(List<String> chunk) {
        return null;
    }

    @Override
    public List<String> processBatchChunk(List<String> chunk, String countryFlag) {
        return null;
    }

    @Override
    public List<String> applyOutputTemplateChunk(List<String> chunk, BatchType batchType) {
        return null;
    }

    @Override
    public void writeOutputChunk(List<String> chunk) {

    }

    @Override
    public String validateOutput(String processedFile) {
        return null;
    }

    @Override
    public void sendNotification() {

    }
}