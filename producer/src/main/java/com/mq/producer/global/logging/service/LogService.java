package com.mq.producer.global.logging.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mq.producer.global.logging.dto.LogRequest;
import com.mq.producer.global.rabbitMQ.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogService {
    private final MessageProducer messageProducer;

    public void save(LogRequest logRequest) throws JsonProcessingException {
        log.info("log save");
        messageProducer.sendMessage(logRequest);
    }
}
