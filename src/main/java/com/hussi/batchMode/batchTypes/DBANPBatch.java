package com.hussi.batchMode.batchTypes;

import com.hussi.batchMode.AbstractBatchScenario;
import com.hussi.batchMode.BatchContext;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

public class DBANPBatch extends AbstractBatchScenario<String, String, File> {

    private final Predicate<String> inputValidator = input -> {
        // Example: input must not be empty and must not contain "FORBIDDEN"
        return input != null && !input.isEmpty() && !input.contains("FORBIDDEN");
    };

    private final Predicate<String> outputValidator = output -> {
        // Example: output must not be null and must not contain "ERROR"
        return output != null && !output.contains("ERROR");
    };

    @Override
    public BatchContext<String, String, File> validateInput(BatchContext<String, String, File> context) {
        System.out.println("DBANPBatch: Custom input validation...");
        List<String> invalidInputs = context.getInputs().stream()
                .filter(inputValidator.negate())
                .toList();
        context.setInputValidationErrors(invalidInputs);
        invalidInputs.forEach(invalid -> System.out.println("Invalid input: " + invalid));
        return context;
    }

    @Override
    public BatchContext<String, String, File> validateOutput(BatchContext<String, String, File> context) {
        System.out.println("DBANPBatch: Custom output validation...");
        List<String> invalidOutputs = context.getOutputs().stream()
                .filter(outputValidator.negate())
                .toList();
        context.setOutputValidationErrors(invalidOutputs);
        invalidOutputs.forEach(invalid -> System.out.println("Invalid output: " + invalid));
        return context;
    }
}
