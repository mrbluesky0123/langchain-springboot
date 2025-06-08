package me.mrbluesky.langchainpractice.external.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("gist")
data class GistFeignProperties (val host: String)