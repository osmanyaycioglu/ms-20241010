package org.training.microservice.mscommon.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String microservice;
    private String boundedContext;
    private String errorDesc;
    private Integer errorCode;


}
