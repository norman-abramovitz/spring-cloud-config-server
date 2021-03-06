package org.freshlegacycode.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@EnableConfigServer
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    @Profile("jdbc")
    @Import(DataSourceAutoConfiguration.class)
    static class JdbcBackendConfiguration {}

    @Profile("redis")
    @Import(RedisAutoConfiguration.class)
    static class RedisBackendConfiguration {}
}

