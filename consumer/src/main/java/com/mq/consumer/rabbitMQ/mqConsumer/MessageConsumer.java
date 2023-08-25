package com.mq.consumer.rabbitMQ.mqConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mq.consumer.mongoDB.dto.LogRequest;
import com.mq.consumer.mongoDB.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageConsumer {
    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void receive(String request) throws JsonProcessingException {
        LogRequest logRequest = objectMapper.readValue(request, LogRequest.class);
        log.info("Received message: {}", logRequest.toString());
        logRepository.save(logRequest.toEntity());
    }
}
