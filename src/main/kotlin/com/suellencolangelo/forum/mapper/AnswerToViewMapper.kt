package com.suellencolangelo.forum.mapper

import com.suellencolangelo.forum.model.domain.Answer
import com.suellencolangelo.forum.model.view.AnswerView
import org.springframework.stereotype.Component

@Component
class AnswerToViewMapper : Mapper<Answer, AnswerView> {

    override fun mapFrom(from: Answer) = AnswerView(
        id = from.id,
        message = from.message,
        createdAt = from.createdAt,
        authorId = from.author.id,
        topicId = from.topic.id,
        isTopicSolution = from.isTopicSolution,
    )
}