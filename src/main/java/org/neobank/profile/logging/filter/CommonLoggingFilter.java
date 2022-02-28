package org.neobank.profile.logging.filter;

import lombok.NonNull;
import lombok.extern.flogger.Flogger;
import org.neobank.profile.logging.filter.entity.Direction;
import org.neobank.profile.logging.filter.entity.LogObject;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import static com.google.common.flogger.LazyArgs.lazy;
import static org.neobank.profile.logging.filter.Constants.CORRELATION_ID;

@Flogger
@Component
public class CommonLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        long duration = 0;
        try
        {
            long startTime = System.currentTimeMillis();
            filterChain.doFilter(request, response);
            duration = System.currentTimeMillis() - startTime;
        }
        finally
        {
            long finalDuration = duration;
            log.atInfo().log("%s", lazy(() -> createEntry(request, response, finalDuration)));
        }
    }

    private LogObject createEntry(HttpServletRequest request, HttpServletResponse response, long duration)
    {
        String uri = request.getRequestURL().toString();
        String method = request.getMethod();
        HashMap<String, String> tracingHeaders = new HashMap<>();
        tracingHeaders.put(CORRELATION_ID, MDC.get(CORRELATION_ID));
        int statusCode = response.getStatus();
        /*HashMap<String, Object> o = new HashMap<>();
        o.put("u", uri);
        o.put("s", statusCode);
        o.put("t", tracingHeaders); */
        return new LogObject(uri, method, tracingHeaders, statusCode, Direction.INBOUND, duration);
    }

}
