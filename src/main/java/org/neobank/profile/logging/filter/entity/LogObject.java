package org.neobank.profile.logging.filter.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogObject
{
    String UriName;
    String MethodName;
    Map<String, String> TracingHeaders;
    int ResponseStatusCode;
    Direction CallDirection;
    long Duration;
}


