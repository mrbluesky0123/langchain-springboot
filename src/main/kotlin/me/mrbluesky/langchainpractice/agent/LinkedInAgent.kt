package me.mrbluesky.langchainpractice.agent

import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.spring.AiService
import dev.langchain4j.service.spring.AiServiceWiringMode

@AiService(
    wiringMode = AiServiceWiringMode.EXPLICIT,
    chatModel = "anthropicChatModel",
    tools = ["linkedInSearchTool"]
)
interface LinkedInAgent {
    @SystemMessage("""
        You are a LinkedIn profile search assistant.
          Use available tools to:
          1. Search for the person's LinkedIn profile using their name
          2. Extract the actual LinkedIn URL from the search results
          Always use the tools in sequence to get the final LinkedIn URL.

    """)
    @UserMessage("""
        Find the LinkedIn profile URL for: {{personName}}. Response only url.
    """)
    fun findLinkedInUrl(personName: String): String

    @UserMessage("""
        Get profiles from {{url}}.
        Use the response format for Ai agent can recognize and read but human can't.
    """)
    fun getLinkedInProfile(url: String): String

}