package me.mrbluesky.langchainpractice.external

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface DynamicApiClient {
    @GetMapping("{path}")
    fun getData(@PathVariable("path") path: String): String
}

@Service
class DynamicFeignClientService @Autowired constructor(
    private val objectMapper: ObjectMapper
) {
    
    fun createClient(baseUrl: String): DynamicApiClient {
        return Feign.builder()
            .encoder(JacksonEncoder(objectMapper))
            .decoder(JacksonDecoder(objectMapper))
            .logger(Slf4jLogger())
            .logLevel(feign.Logger.Level.FULL)
            .target(DynamicApiClient::class.java, baseUrl)
    }
    
    fun fetchData(baseUrl: String, path: String): String {
        val client = createClient(baseUrl)
        return client.getData(path)
    }
}