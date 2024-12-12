package com.esiea.twitterclone.service;

import com.esiea.twitterclone.model.MessageDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class MessageService {

    private final Sinks.Many<MessageDTO> sink = Sinks.many().multicast().onBackpressureBuffer();

    private final List<MessageDTO> messages = new ArrayList<>();

    public void addMessage(MessageDTO messageDTO) {
        messages.add(messageDTO);
        sink.tryEmitNext(messageDTO);
    }
}
