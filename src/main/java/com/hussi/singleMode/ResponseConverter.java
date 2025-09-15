package com.hussi.singleMode;

import com.hussi.model.DecodedPojo;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseConverter {

    public static ResponseEntity<DecodedPojo> convertToResponseEntity(DecodedPojo decodedVin) {
        return ResponseEntity.ok(decodedVin);
    }
}
