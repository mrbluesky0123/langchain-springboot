package me.mrbluesky.langchainpractice.external.config

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Request
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableFeignClients(basePackages = ["me.mrbluesky.langchainpractice.external"])
@EnableConfigurationProperties(GistFeignProperties::class)
class GistFeignConfig {
//    @Bean
//    fun requestInterceptor(
//        @Qualifier("snake-case-mapper") mapper: ObjectMapper,
//    ) = RequestInterceptor { _ ->
//
//    }

    @Bean
    fun requestOptions(): Request.Options =
        Request.Options(
            5000, TimeUnit.MILLISECONDS,
            10000, TimeUnit.MILLISECONDS,
            true
        )

    @Bean
    fun feignLoggerLevel(): feign.Logger.Level = feign.Logger.Level.FULL
}