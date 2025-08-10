//package com.hussi.dummy.executor;
//
//import com.hussi.dummy.usecase.UseCase;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.function.Function;
//
//public interface UseCaseExecutor {
//    // I -> input
//    // O -> output
//    // F -> function
//    <I,O,F> CompletableFuture<F> execute(
//            UseCase<I,O> useCase,
//            I input,
//            I countryFlag,
//            Function<O,F> dtoToResponseMapper
//    );
//}
