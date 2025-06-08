package me.mrbluesky.langchainpractice.config

import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.chat.StreamingChatModel
import dev.langchain4j.model.chat.listener.ChatModelListener
import me.mrbluesky.langchainpractice.listener.MyListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AssistantConfiguration {
    /**
     * This chat memory will be used by [Assistant] and [StreamingAssistant]
     */
//    @Bean
//    @Scope(SCOPE_PROTOTYPE)
//    fun chatMemory(): ChatMemory? {
//        return MessageWindowChatMemory.withMaxMessages(10)
//    }

    /**
     * This listener will be injected into every [ChatModel] and [StreamingChatModel]
     * bean found in the application context.
     * It will listen for [ChatModel] in the [ChatModelController] as well as
     * [Assistant] and [StreamingAssistant].
     */
    @Bean
    fun chatModelListener(): ChatModelListener {
        return MyListener()
    }
}