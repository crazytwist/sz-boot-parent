package com.sz.mongo;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName JsonService
 * @Author mengke
 * @create 2025/5/1 00:53
 * @Description
 */
@Service
public class JsonService {

    private final JsonDocumentRepository repository;

    public JsonService(JsonDocumentRepository repository) {
        this.repository = repository;
    }

    public void storeJson(String source, Map<String, Object> jsonData) {
        JsonDocument doc = new JsonDocument();
        doc.setSource(source);
        doc.setData(jsonData);
        doc.setCreatedAt(Instant.now());
        repository.save(doc);
    }

    public List<JsonDocument> findBySource(String source) {
        return repository.findBySource(source);
    }

    public JsonDocument findBySourceId(String id) {
        Optional<JsonDocument> byId = repository.findById(id);
        return byId.orElse(null);
    }
}
