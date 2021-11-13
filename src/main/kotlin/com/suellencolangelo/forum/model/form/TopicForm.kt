package com.suellencolangelo.forum.model.form

data class TopicForm(
    val title: String,
    val message: String,
    val authorId: Long,
    val courseId: Long,
)
