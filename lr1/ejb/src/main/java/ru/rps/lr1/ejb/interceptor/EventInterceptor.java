package ru.rps.lr1.ejb.interceptor;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class EventInterceptor {
    private static Logger log = Logger.getLogger("EventInterceptor");

    @PostConstruct
    public void logCreation(InvocationContext cnt) {
        String objectName = cnt.getTarget().toString();
        log.log(Level.INFO, String.format("Created %s, Time: %tT", objectName, LocalDateTime.now()));
        try {
            cnt.proceed();
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format("Exception: %s", e));
        }
    }

    @AroundInvoke
    public Object logInvocation(InvocationContext cnt) throws Exception {
        StringBuilder params = new StringBuilder();
        for(Object parameter : cnt.getParameters()) {
            params.append(parameter.toString());
        }
        log.log(Level.INFO, String.format("Method %s was invoked with parameters: %s", cnt.getMethod().getName(), params.toString()));
        return cnt.proceed();
    }
}
