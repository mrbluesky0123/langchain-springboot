package me.mrbluesky.langchainpractice.tool

import dev.langchain4j.web.search.tavily.TavilyWebSearchEngine
import org.springframework.stereotype.Component

@Component
class WebSearchComponent(
    val tavilyWebSearchEngine: TavilyWebSearchEngine
) {
    fun getProfileUrlByTavily(name: String): String =
        tavilyWebSearchEngine.search("$name linkedin profile")
            .run {
                this.toString()
            }

}