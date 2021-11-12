package com.suellencolangelo.forum.dto

data class TopicDto(
    val title: String,
    val message: String,
    val authorId: Long,
    val courseId: Long,
)
