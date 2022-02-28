package org.neobank.profile.logging.filter;

import lombok.NonNull;
import lombok.extern.flogger.Flogger;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static org.neobank.profile.logging.filter.Constants.CORRELATION_ID;

@Component
@Flogger
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PopulateMDCFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        populateMDCFromRequest(request);
        filterChain.doFilter(request, response);
    }

    //Extend this method in future to extract session id, channel id if required to log / use further in request journey
    private void populateMDCFromRequest(HttpServletRequest request) {
        MDC.put(CORRELATION_ID, getCorrelationId(request.getHeader(CORRELATION_ID)));
    }

    private String getCorrelationId(String correlation_id_from_header)
    {
        return Optional.ofNullable(correlation_id_from_header)
                .orElse(UUID.randomUUID().toString());
    }
}

