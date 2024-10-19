package org.training.microservice.msorder.integration.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;
import org.training.microservice.mscommon.error.ErrorObj;

import java.io.IOException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public IntegrationException decode(final String sParam,
                                       final Response responseParam) {
        ObjectMapper objectMapperLoc = new ObjectMapper();
        try {
            ErrorObj errorObjLoc = objectMapperLoc.readValue(responseParam.body()
                                                                          .asInputStream(),
                                                             ErrorObj.class);
            return new IntegrationException(errorObjLoc);
        } catch (Exception eParam) {
            throw new IntegrationException(ErrorObj.builder()
                                                   .withErrorCode(10000)
                                                   .withErrorDesc(eParam.getMessage())
                                                   .build());
        }
    }
}
