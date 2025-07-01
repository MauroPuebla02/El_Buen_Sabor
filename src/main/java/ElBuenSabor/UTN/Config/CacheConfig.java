package ElBuenSabor.UTN.Config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        // Sin parámetros: crea caches "on-the-fly" según el nombre que uses en @Cacheable
        CaffeineCacheManager mgr = new CaffeineCacheManager();
        mgr.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(Duration.ofSeconds(60))  // expira a los 60s
                        .maximumSize(200)                          // hasta 200 entradas
        );
        return mgr;
    }
}