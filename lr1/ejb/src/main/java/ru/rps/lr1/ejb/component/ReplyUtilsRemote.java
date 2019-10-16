package ru.rps.lr1.ejb.component;

import javax.ejb.Remote;

@Remote
public interface ReplyUtilsRemote {
    String reply(String message);
}
