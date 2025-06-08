package me.mrbluesky.langchainpractice.models

import dev.langchain4j.model.anthropic.AnthropicChatModel
import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.chat.listener.ChatModelListener
import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.model.openai.OpenAiChatModelName
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class ChatModelConfigs(
    val environment: Environment,
    val chatModelListener: ChatModelListener
) {

    @Bean(name = ["openaiChatModel"])
    fun openaiChatModels(): ChatModel =
        OpenAiChatModel.builder()
            .apiKey("sk-proj-_xxxxxxxxxxxxxx-UCSKq4kA")
            .modelName(OpenAiChatModelName.GPT_3_5_TURBO)
            .build()


    @Bean(name = ["ollamaChatModel"])
    fun ollamaChatModels(): ChatModel =
        dev.langchain4j.model.ollama.OllamaChatModel.builder()
            .baseUrl("http://localhost:11434")
            .modelName("llama3.2:latest")
            .build()

    @Bean(name = ["anthropicChatModel"])
    fun anthropicChatModels(): ChatModel =
        AnthropicChatModel.builder()
            .apiKey(environment.getProperty("ANTHROPIC_API_KEY"))
            .modelName("claude-3-5-sonnet-20240620")
            .listeners(arrayListOf<ChatModelListener>(chatModelListener))
            .logRequests(true)
            .logResponses(true)
            .build()

}