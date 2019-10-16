package ru.rps.lr1.ejb.component;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import ru.rps.lr1.ejb.interceptor.EventInterceptor;

@Interceptors(EventInterceptor.class)
@Stateless
public class ReplyUtils implements ReplyUtilsRemote {
    @Override
    public String reply(String message) {
        return message;
    }
}
