package com.suellencolangelo.forum.model.view

import java.time.LocalDateTime

data class AnswerView(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val authorId: Long?,
    val topicId: Long?,
    val isTopicSolution: Boolean
)