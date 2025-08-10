//package com.hussi.dummy.executor;
//
//import com.hussi.dummy.usecase.UseCase;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.function.Function;
//
//public class UseCaseExecutorImpl implements UseCaseExecutor {
//
//    // I -> input
//    // O -> output
//    // F -> function
//    @Override
//    public <I, O, F> CompletableFuture<F> execute(
//            UseCase<I, O> useCase,
//            I input,
//            I countryFlag,
//            Function<O, F> dtoToResponseMapper) {
//        return CompletableFuture.supplyAsync(() -> input)
//                .thenApplyAsync(i -> useCase.execute(i, countryFlag))
//                .thenApplyAsync(dtoToResponseMapper);
//    }
//}
