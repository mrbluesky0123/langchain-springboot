package me.mrbluesky.langchainpractice.config

import dev.langchain4j.web.search.tavily.TavilyWebSearchEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class TavilyConfiguration(
    val env: Environment
) {
    @Bean
    fun getTavilyWebSearchEngine(): TavilyWebSearchEngine =
        TavilyWebSearchEngine.builder()
            .apiKey(env.getProperty("TAVILY_API_KEY"))
            .includeRawContent(true)
            .build()
}