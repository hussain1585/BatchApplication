package com.hussi.service;

import java.io.File;
import java.util.List;

public interface BatchLifeCycle {
    void validateInput(String inputFilePath);
    List<File> breakInput(String inputFilePath);
    List<String> processChunks(List<File> chunkFiles);
    List<String> formatOutput(List<String> rawOutputs);
    void writeOutputFile(List<String> formattedOutput, String uuid);

}
