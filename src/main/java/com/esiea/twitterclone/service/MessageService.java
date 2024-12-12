package com.esiea.twitterclone.service;

import com.esiea.twitterclone.model.MessageDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Service
public class MessageService {

    private final Sinks.Many<MessageDTO> sink = Sinks.many().multicast().onBackpressureBuffer();

    private final List<MessageDTO> messages = new ArrayList<>();
    private final Queue<MessageDTO> messageQueue = new LinkedList<>();

    public void addMessage(MessageDTO messageDTO) {
        messages.add(messageDTO);
        messageQueue.offer(messageDTO);
        sink.tryEmitNext(messageDTO);
    }
}
