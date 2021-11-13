package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.model.form.TopicForm
import com.suellencolangelo.forum.model.domain.Answer
import com.suellencolangelo.forum.model.domain.Course
import com.suellencolangelo.forum.model.domain.Topic
import com.suellencolangelo.forum.model.domain.User
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val courseService: CourseService,
    private val authorService: AuthorService
) {

    private val dummyTopic: Topic
        get() {
            val topic = Topic(
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
            return topic.copy(answers = listOf(makeDummyAnswer(topic)))
        }

    private val topics: MutableList<Topic> = mutableListOf(dummyTopic, dummyTopic, dummyTopic)

    private fun makeDummyAnswer(topic: Topic): Answer = Answer(
        id = 1,
        message = "Dúvida Respondida",
        topic = topic,
        author = User(
            id = (1L..10L).random(),
            name = "Mari Oliveira",
            email = "mari@oliveira.com.br"
        ),
        isTopicSolution = false
    )

    fun list(): List<Topic> = topics

    fun searchById(id: Long): Topic? {
        return topics.firstOrNull { it.id == id }
    }

    fun searchByAnswerFromTopic(id: Long): List<Answer> {
        return topics.firstOrNull { it.id == id }?.answers.orEmpty()
    }

    fun register(dto: TopicForm) {
        val topic = dummyTopic.copy(
            title = dto.title,
            message = dto.message,
            course =  courseService.searchById(dto.courseId),
            author = authorService.searchById(dto.authorId)
        )
        topics.add(topic)
    }
}