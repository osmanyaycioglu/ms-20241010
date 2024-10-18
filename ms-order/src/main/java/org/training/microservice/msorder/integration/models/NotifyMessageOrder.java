package org.training.microservice.msorder.integration.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotifyMessageOrder {
    private String message;
    private String destination;

}
