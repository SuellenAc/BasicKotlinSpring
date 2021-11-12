package com.suellencolangelo.forum.model.dto

data class TopicDto(
    val title: String,
    val message: String,
    val authorId: Long,
    val courseId: Long,
)
