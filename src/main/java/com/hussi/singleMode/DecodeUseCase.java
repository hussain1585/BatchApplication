package com.hussi.singleMode;

import com.hussi.model.DecodedPojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DecodeUseCase extends UseCase<String, DecodedPojo> {

    @Qualifier("rules")
    private final List<IBusinessRule> rules;

    @Override
    public DecodedPojo execute(String vin, String countryFlag) {
        long startTime = System.nanoTime();
        DecodedPojo DecodedPojo = new DecodedPojo(vin);
        rules.stream()
                .filter(rule -> (rule instanceof IBusinessRuleWithCheck ruleWithCheck && ruleWithCheck.check(DecodedPojo, countryFlag)) || (rule instanceof IBusinessRuleWithoutCheck))
                .forEach(rule -> {
                    try {
                        rule.apply(DecodedPojo, countryFlag);
                    } catch (Exception e) {
                        log.debug("Error occurred while applying rule: {} with error : {}", rule.getClass().getSimpleName(), e.getMessage());
                        DecodedPojo.setDecodedPojoErrors(true);
                        DecodedPojo.setErrorMessage(e.getMessage());
                    }
                });
        long endTime = System.nanoTime();
        long durationNanos = endTime - startTime;
        long durationMillis = durationNanos / 1000000;
        log.debug("DecodeUseCase => time taken for execute method for vin => {} in ms => {} and in nanos => {}", vin, durationMillis, durationNanos);
        return DecodedPojo;
    }
}
