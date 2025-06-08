package me.mrbluesky.langchainpractice.listener

import dev.langchain4j.model.chat.listener.ChatModelErrorContext
import dev.langchain4j.model.chat.listener.ChatModelListener
import dev.langchain4j.model.chat.listener.ChatModelRequestContext
import dev.langchain4j.model.chat.listener.ChatModelResponseContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class MyListener : ChatModelListener {
    override fun onRequest(requestContext: ChatModelRequestContext) {
        log.info("onRequest(): {}", requestContext.chatRequest())
    }

    override fun onResponse(responseContext: ChatModelResponseContext) {
        log.info("onResponse(): {}", responseContext.chatResponse())
    }

    override fun onError(errorContext: ChatModelErrorContext) {
        log.info("onError(): {}", errorContext.error().message)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(MyListener::class.java)
    }
}