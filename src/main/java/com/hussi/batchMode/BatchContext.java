package com.hussi.batchMode;

import lombok.Data;

import java.util.List;

@Data
public class BatchContext<I, O, F> {
    private List<I> inputs;
    private List<O> outputs;
    private List<F> fileWritables;
    private List<String> inputValidationErrors;
    private List<String> outputValidationErrors;
    private String notificationEvent;

    private List<List<I>> inputChunks; // Each chunk contains up to 1M inputs
    private int currentChunkIndex;

}
