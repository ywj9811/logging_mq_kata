package com.mq.consumer.mongoDB.repository;

import com.mq.consumer.mongoDB.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
}