package me.mrbluesky.langchainpractice

//import dev.langchain4j.LangChain4jAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LangchainPracticeApplication

fun main(args: Array<String>) {
    runApplication<LangchainPracticeApplication>(*args)
}
