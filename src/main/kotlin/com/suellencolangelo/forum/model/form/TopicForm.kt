package com.suellencolangelo.forum.model.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicForm(
    @field:NotEmpty @field:Size(min = 5, max = 100) val title: String,
    @field:NotEmpty @field:Size(min = 5, max = 100) val message: String,
    @field:NotNull val authorId: Long,
    @field:NotNull val courseId: Long,
)
