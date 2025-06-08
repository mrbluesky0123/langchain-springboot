package me.mrbluesky.langchainpractice.external

import feign.Response
import me.mrbluesky.langchainpractice.external.config.GistFeignConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "gistFeignClient", url = "\${gist.host}", configuration = [GistFeignConfig::class])
interface GistFeignClient {
    @GetMapping("acee27f977815c8fc285122938b001a4/raw/50541acea568534557aad94f1e3c5974962fdef2/randy_kang.json")
    fun getLinkedinProfile(): String
}