package me.mrbluesky.langchainpractice.pojo

import dev.langchain4j.model.output.structured.Description

@Description("Someones's profile from Linkedin")
data class Profile(
    val name: String,
    val company: String,
    val skills: List<String>,
    val interestingThingsList: List<String>
){
}