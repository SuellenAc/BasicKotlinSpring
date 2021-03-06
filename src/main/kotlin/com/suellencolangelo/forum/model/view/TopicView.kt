package com.suellencolangelo.forum.model.view

import com.suellencolangelo.forum.model.domain.StatusTopic
import com.suellencolangelo.forum.model.domain.Topic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val createdAt: LocalDateTime
)
