package com.poc.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean("brandFilterCacheManager")
    @Primary
    public CacheManager brandCacheManager() {
        return getCacheManager("brandCacheManager", 5, 5);
    }

    @Bean("priceFilterCacheManager")
    public CacheManager priceCacheManager() {
        return getCacheManager("priceCacheManager", 2, 3);
    }

    private CacheManager getCacheManager(String cacheName, int secondsExpiry, long entriesSize) {
        CaffeineCache cache = buildCache(cacheName, secondsExpiry, entriesSize);
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Collections.singleton(cache));
        return manager;
    }

    private CaffeineCache buildCache(String cacheName, int secondsExpiry, long entriesSize) {
        return new CaffeineCache(
                cacheName,
                Caffeine
                        .newBuilder()
                        .expireAfterWrite(secondsExpiry, TimeUnit.SECONDS)
                        .maximumSize(entriesSize)
                        .build()
        );
    }

}
