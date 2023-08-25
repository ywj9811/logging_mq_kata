package com.mq.consumer.mongoDB.dto;

import com.mq.consumer.mongoDB.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LogRequest {
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;
    public LogRequest(String logId, Integer executeTime, String methodName) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
    }
    public Log toEntity() {
        if (exceptionMessage == null)
            exceptionMessage = "";
        return new Log(logId, executeTime, methodName, exceptionMessage);
    }
}
