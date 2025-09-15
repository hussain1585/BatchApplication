package com.hussi.batchMode.batchTypes;

import com.hussi.batchMode.AbstractBatchScenario;

import java.util.List;

public class QANPBatch extends AbstractBatchScenario<String, String> {
    @Override
    public void validateInput(List<String> inputs) {
        System.out.println("QANPBatch: Custom input validation...");
        // Custom validation logic for QANPBatch
        // e.g., check for specific format, length, etc.
    }

    @Override
    public void validateOutput(List<String> outputs) {
        System.out.println("QANPBatch: Custom output validation...");
        // Custom output validation logic for QANPBatch
    }
}
