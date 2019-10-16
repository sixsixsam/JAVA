package ru.rps.lr1.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ru.rps.lr1.ejb.component.ReplyUtilsRemote;
import ru.rps.lr1.web.component.ChatStateLocal;

@Named("chat")
@ConversationScoped
public class ChatController implements Serializable {
    @EJB
    private ReplyUtilsRemote replyUtils;
    @EJB
    private ChatStateLocal chatState;

    private String message;
    private boolean isStarted;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public String send() {
        if(!message.equals("")) {
            chatState.save(String.format("You: %s", message));
            chatState.save(String.format("Server: %s", replyUtils.reply(message)));
            message = "";
        }
        return "chat";
    }

    public List<String> getMessages() {
        return chatState.history();
    }

    public void start() {
        chatState.start();
        isStarted = true;
    }

    public void stop() {
        chatState.stop();
        isStarted = false;
    }
}
