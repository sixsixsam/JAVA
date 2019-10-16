package ru.rps.lr1.web.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

@ConversationScoped
@Stateful
public class ChatState implements ChatStateLocal, Serializable {

    @Inject
    private Conversation conversation;
    private List<String> messages;

    public ChatState() {
        messages = new ArrayList<>();
    }

    @Override
    public void start() {
        conversation.begin();
    }

    @Override
    public void save(String message) {
        messages.add(message);
    }

    @Override
    public List<String> history() {
        return messages;
    }

    @Override
    public void stop() {
        conversation.end();
    }
}
