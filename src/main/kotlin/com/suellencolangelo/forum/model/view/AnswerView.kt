package com.suellencolangelo.forum.model.view

import com.suellencolangelo.forum.model.domain.Answer
import java.time.LocalDateTime

data class AnswerView(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val authorId: Long?,
    val topicId: Long?,
    val isTopicSolution: Boolean
)

fun Answer.toView() = AnswerView(
    id = this.id,
    message = this.message,
    createdAt = this.createdAt,
    authorId = this.author.id,
    topicId = this.topic.id,
    isTopicSolution = this.isTopicSolution,
)