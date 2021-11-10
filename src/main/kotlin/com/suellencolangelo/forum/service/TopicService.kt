package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.model.Course
import com.suellencolangelo.forum.model.Topic
import com.suellencolangelo.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService {

    fun list(): List<Topic> = listOf(getDummyTopic(), getDummyTopic(), getDummyTopic())

    private fun getDummyTopic(): Topic = Topic(
        id = 1,
        title = "Dúvida",
        message = "Variaveis no kotlin",
        course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação",
        ),
        author = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com.br"
        )
    )

}