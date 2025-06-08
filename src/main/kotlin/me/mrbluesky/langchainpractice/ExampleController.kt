package me.mrbluesky.langchainpractice

import me.mrbluesky.langchainpractice.agent.LinkedInAgent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import me.mrbluesky.langchainpractice.external.GistFeignClient
import me.mrbluesky.langchainpractice.pojo.Profile
import me.mrbluesky.langchainpractice.service.AnthropicAssistant
import me.mrbluesky.langchainpractice.service.LlamaAssistant
import me.mrbluesky.langchainpractice.tool.WebSearchComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment

@RestController
class ExampleController(
    val environment: Environment,
    val anthropicAssistant: AnthropicAssistant,
    val llamaAssistant: LlamaAssistant,
    val gistFeignClient: GistFeignClient,
    val webSearchComponent: WebSearchComponent,
    val linkedInAgent: LinkedInAgent,
) {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping("/anthropic/profile_summary")
    fun anthropicProfileSummary(@RequestParam(value = "message", defaultValue = "Hello") message: String): Profile {
        val linkedInProfileUrl = linkedInAgent.findLinkedInUrl(message)
        logger.info("### URL: $linkedInProfileUrl")
//        val linkedInProfile = linkedInAgent.getLinkedInProfile(linkedInProfileUrl)
        val linkedInProfile = gistFeignClient.getLinkedinProfile()  // mock
        val answer = anthropicAssistant.getProfileSummaryPojo(linkedInProfile)
        return answer
    }

    @GetMapping("/llama/profile_summary")
    fun llamaProfileSummary(@RequestParam(value = "message", defaultValue = "Hello") message: String): String {
        val linkedinProfile = gistFeignClient.getLinkedinProfile()
        val answer = llamaAssistant.getProfileSummary(linkedinProfile)
        return answer
    }
    @GetMapping("/profile_url")
    fun getLinkedinProfileUrl(@RequestParam name: String): String {
        return webSearchComponent.getProfileUrlByTavily(name)
    }
}