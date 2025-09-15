package com.hussi.batchMode.executor;

import com.hussi.batchMode.IBatchScenario;
import com.hussi.batchMode.BatchContext;
import java.util.concurrent.CompletableFuture;

public interface IBatchExecutor<I, O, F> {
    CompletableFuture<BatchContext<I, O, F>> execute(IBatchScenario<I, O, F> scenario);
}