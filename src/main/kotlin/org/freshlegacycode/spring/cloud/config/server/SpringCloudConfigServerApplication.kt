package org.freshlegacycode.spring.cloud.config.server

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.vault.config.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile

@EnableConfigServer
@SpringBootApplication
class SpringCloudConfigServerApplication {

    @Profile("vault")
    @Configuration
    @Import(DiscoveryClientVaultBootstrapConfiguration::class,
            VaultBootstrapConfiguration::class,
            VaultReactiveBootstrapConfiguration::class,
            VaultBootstrapPropertySourceConfiguration::class)
    @ImportAutoConfiguration(VaultHealthIndicatorAutoConfiguration::class)
    class VaultConfig
}

fun main(args: Array<String>) {
    runApplication<SpringCloudConfigServerApplication>(*args)
}

