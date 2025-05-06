package com.sz.jobrunr.config;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.configuration.JobRunrConfiguration;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.mysql.MySqlStorageProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName JobRunrAutoConfiguration
 * @Author mengke
 * @create 2025/4/13 16:12
 * @Description
 */
@Configuration
@ConditionalOnProperty(name = "jobrunr.enabled", havingValue = "true", matchIfMissing = true)
public class JobRunrAutoConfiguration {

    @Bean
    public StorageProvider storageProvider(DataSource dataSource) {
        return new MySqlStorageProvider(dataSource);
    }

    @Bean
    public JobRunrConfiguration.JobRunrConfigurationResult jobRunrInitializer(StorageProvider storageProvider) {
        return JobRunr.configure()
                .useStorageProvider(storageProvider)
                .useBackgroundJobServer()
                .useDashboard()
                .initialize();
    }
}