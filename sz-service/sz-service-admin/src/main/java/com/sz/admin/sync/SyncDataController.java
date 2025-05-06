package com.sz.admin.sync;

import com.sz.core.common.entity.ApiResult;
import com.sz.mongo.JsonDocument;
import com.sz.mongo.JsonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SyncDataController
 * @Author mengke
 * @create 2025/5/1 01:09
 * @Description
 */
@Tag(name = "同步数据")
@RestController
@RequestMapping("/sync")
@RequiredArgsConstructor
@Slf4j
public class SyncDataController {

    private final JsonService jsonService;

    @Operation(summary = "新增")
    @PostMapping
    public ApiResult<Void> create(@RequestBody Map<String, Object> json) {
        jsonService.storeJson("json", json);
        return ApiResult.success();
    }

    @Operation(summary = "查询列表")
    @GetMapping("list")
    public ApiResult<List<JsonDocument>> search(@RequestParam String source) {
        return ApiResult.success(jsonService.findBySource(source));
    }

    @Operation(summary = "查询单个")
    @GetMapping
    public ApiResult<JsonDocument> searchById(@RequestParam String id) {
        JsonDocument jsonDocument = jsonService.findBySourceId(id);
        return ApiResult.success(jsonDocument);
    }

}
