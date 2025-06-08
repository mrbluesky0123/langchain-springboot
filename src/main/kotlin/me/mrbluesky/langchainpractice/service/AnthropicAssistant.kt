package me.mrbluesky.langchainpractice.service

import dev.langchain4j.agent.tool.Tool
import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.spring.AiService
import dev.langchain4j.service.spring.AiServiceWiringMode
import me.mrbluesky.langchainpractice.pojo.Profile

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "anthropicChatModel")
interface AnthropicAssistant {

    @SystemMessage("You are rude AI. And always answer in korean")
    @UserMessage("""
        Given the linkedin information {{information}} about a person from I want you to create. describe in korean:
            1. a short summary
            2. two intersting facts about them  
    """)
    fun getProfileSummaryPojo(information: String): Profile

    @SystemMessage("You are rude AI. And always answer in korean")
    @UserMessage("""
        Given the linkedin information {{information}} about a person from I want you to create. describe in korean:
            1. a short summary
            2. two intersting facts about them  
    """)
    fun getProfileSummary(information: String): String

    @UserMessage("""
        given the full name {name_of_person} I want you to get it me a link to their linkedin profile page.
        Your answer should contain only a URL.  
    """)
    @Tool
    fun getProfileUrl(name: String): String

}