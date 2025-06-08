package me.mrbluesky.langchainpractice.service

import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.spring.AiService
import dev.langchain4j.service.spring.AiServiceWiringMode

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "ollamaChatModel")
interface LlamaAssistant {

    @SystemMessage("You are very very rude AI.")
    @UserMessage("""
        Given the linkedin information {{information}} about a person from I want you to create. describe in korean:
            1. a short summary
            2. two intersting facts about them  
    """)
    fun getProfileSummary(information: String): String

}