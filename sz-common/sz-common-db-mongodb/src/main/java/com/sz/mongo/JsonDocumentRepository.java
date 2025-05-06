package com.sz.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ClassName JsonDocumentRepository
 * @Author mengke
 * @create 2025/5/1 00:52
 * @Description
 */
public interface JsonDocumentRepository extends MongoRepository<JsonDocument, String> {

    // 按 source 查询所有文档
    List<JsonDocument> findBySource(String source);
}
