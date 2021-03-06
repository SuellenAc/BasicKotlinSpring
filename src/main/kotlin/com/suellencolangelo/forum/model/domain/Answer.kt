package com.suellencolangelo.forum.model.domain

import java.time.LocalDateTime

data class Answer(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val isTopicSolution: Boolean
)
