package com.mq.producer.global.logging.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class TraceStatus {
    private String threadId;
    private Long startTime;
    private String methodName;
}
