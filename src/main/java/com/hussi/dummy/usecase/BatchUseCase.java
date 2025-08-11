package com.hussi.dummy.usecase;

import com.hussi.enums.BatchType;
import com.hussi.model.DecodedPojo;

import java.io.File;
import java.util.List;

public abstract class BatchUseCase {

    /**
     * generated a random UUID
     */
    public abstract String generateBatchUuid(String s3Location);

//    /**
//     * takes UUID
//     * creates a folder in S3 temp
//     * for each million break a file and upload as UUID_file_count
//     * returns UUID
//     */
//    public abstract String breakFile(String uuid);

    /* */
    public abstract List<String> downloadFile(String input);

    // Works on one chunk
    public abstract boolean validateInput(List<String> inputList);

    public abstract List<DecodedPojo> processBatch(List<String> inputList, String countryFlag);

    public abstract File applyOutputTemplate(List<DecodedPojo> outputList, BatchType batchType);

    public abstract File writeOutputToFile(List<DecodedPojo> outputList);

    public abstract String uploadFile(List<DecodedPojo> outputList);

    // Final validation on full file
    public abstract String validateOutput(String processedFile);

    public abstract void sendNotification();
}