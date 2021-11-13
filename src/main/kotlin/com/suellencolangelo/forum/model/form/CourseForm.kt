package com.suellencolangelo.forum.model.form

import javax.validation.constraints.NotEmpty

data class CourseForm(
    @field:NotEmpty val name: String,
    @field:NotEmpty val category: String,
)
