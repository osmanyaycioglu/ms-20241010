package org.training.microservice.msorder.integration.resliency;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.training.microservice.mscommon.error.ErrorObj;
import org.training.microservice.msorder.integration.common.IntegrationException;

import java.io.IOException;
import java.util.function.Predicate;

public class CheckIntegrationException implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable throwableParam) {
        if (throwableParam instanceof IllegalArgumentException) {
            return false;
        } else if (throwableParam instanceof IOException) {
            return true;
        } else if (throwableParam instanceof RestClientResponseException) {
            RestClientResponseException exceptionLoc      = (RestClientResponseException) throwableParam;
            ErrorObj                    responseBodyAsLoc = exceptionLoc.getResponseBodyAs(ErrorObj.class);
            return switch (responseBodyAsLoc.getErrorCode()) {
                case 1024, 1058, 2021 -> true;
                default -> false;
            };

        } else if (throwableParam instanceof IntegrationException) {
            IntegrationException exceptionLoc = (IntegrationException) throwableParam;
            Integer errorCodeLoc = exceptionLoc.getErrorObj()
                                               .getErrorCode();
            switch (errorCodeLoc) {
                case 1024:
                case 1058:
                case 2021:
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

}
