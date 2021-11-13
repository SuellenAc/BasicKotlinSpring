package com.suellencolangelo.forum.mapper

import com.suellencolangelo.forum.model.domain.Topic
import com.suellencolangelo.forum.model.view.TopicView
import org.springframework.stereotype.Component

@Component
class TopicToViewMapper : Mapper<Topic, TopicView> {

    override fun mapFrom(from: Topic) = TopicView(
        id = from.id,
        title = from.title,
        message = from.message,
        status = from.status,
        createdAt = from.createdAt
    )
}