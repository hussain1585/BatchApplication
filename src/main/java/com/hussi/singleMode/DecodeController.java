package com.hussi.singleMode;

import com.hussi.model.DecodedPojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * The DecodeController class is a REST controller responsible for handling VIN decoding requests.
 * It implements the IController interface, which defines a method for decoding a VIN.
 *
 * <p>This class uses the UseCaseExecutor to execute the decode use case asynchronously. The decode
 * method takes a VIN as input and returns a CompletableFuture that wraps a ResponseEntity
 * containing the decoded VIN.
 *
 * <p>The @RestController annotation indicates that this class is a Spring REST controller.
 * The @RequiredArgsConstructor annotation generates a constructor with required arguments, which
 * are the final fields in the class.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/evd/read")
public class DecodeController implements IController<String, DecodedPojo> {

    private final UseCaseExecutor useCaseExecutor;
    private final UseCase<String, DecodedPojo> decodeUseCase;

    private final ModelYearService modelYearService;

    @Override
    public CompletableFuture<ResponseEntity<DecodedPojo>> decode(String vin, String countryFlag) {
        long startTime = System.nanoTime();
        log.debug("decode controller => vin => {}", vin);
        CompletableFuture<ResponseEntity<DecodedPojo>> response = useCaseExecutor
                .execute(decodeUseCase, vin, countryFlag == null ? "US" : countryFlag, ResponseConverter::convertToResponseEntity);
        long endTime = System.nanoTime();
        long durationNanos = endTime - startTime;
        long durationMillis = durationNanos / 1000000;
        log.debug("DecodeController => time taken for rest API for vin => {} in ms => {} and in nanos => {}", vin, durationMillis, durationNanos);
        return response;
    }

    @Override
    public CompletableFuture<ResponseEntity<DecodedPojo>> decodeForVhr(String vin, String countryFlag) {
        return null;
    }
}
