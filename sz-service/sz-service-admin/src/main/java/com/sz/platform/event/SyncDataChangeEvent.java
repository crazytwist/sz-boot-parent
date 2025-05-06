package com.sz.platform.event;

import com.sz.core.common.event.BaseEvent;

/**
 * @ClassName SyncDataChangeEvent
 * @Author mengke
 * @create 2025/5/5 21:18
 * @Description
 */
public class SyncDataChangeEvent extends BaseEvent<SyncDataMeta> {
    protected SyncDataChangeEvent(Object source, SyncDataMeta payload) {
        super(source, payload);
    }
}
