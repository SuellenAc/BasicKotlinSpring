package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.model.Course
import com.suellencolangelo.forum.model.Topic
import com.suellencolangelo.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService {

    private val dummyTopic: Topic
        get() = Topic(
            id = (1L..10L).random(),
            title = "Dúvida",
            message = "Variaveis no kotlin",
            course = Course(
                id = (1L..10L).random(),
                name = "Kotlin",
                category = "Programação",
            ),
            author = User(
                id = (1L..10L).random(),
                name = "Ana da Silva",
                email = "ana@email.com.br"
            )
        )

    private val topics: List<Topic> = listOf(dummyTopic, dummyTopic, dummyTopic)

    fun list(): List<Topic> = topics

    fun searchById(id: Long): Topic? {
        return topics.firstOrNull { it.id == id }
    }
}