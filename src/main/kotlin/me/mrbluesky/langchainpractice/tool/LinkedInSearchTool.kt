package me.mrbluesky.langchainpractice.tool

import dev.langchain4j.agent.tool.Tool
import dev.langchain4j.web.search.tavily.TavilyWebSearchEngine
import org.springframework.stereotype.Component

@Component
class LinkedInSearchTool(
    private val webSearchComponent: WebSearchComponent
) {
    @Tool("Search for a person's LinkedIn profile URL using their name")
    fun searchLinkedInProfile(personName: String): String =
        webSearchComponent.getProfileUrlByTavily(personName)
}