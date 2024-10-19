package org.training.microservice.msorder.integration.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.training.microservice.mscommon.error.ErrorObj;

@Data
@RequiredArgsConstructor
public class IntegrationException extends RuntimeException {
    private final ErrorObj errorObj;

}
