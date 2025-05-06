package com.sz.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

/**
 * @ClassName JsonDocument
 * @Author mengke
 * @create 2025/5/1 00:49
 * @Description
 */
@Data
@Document(collection = "json_store")
public class JsonDocument {

    @Id
    private String id; // MongoDB 的 _id 字段

    private String source;

    private Map<String, Object> data;

    private Instant createdAt;
}
