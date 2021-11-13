package com.suellencolangelo.forum.mapper

import com.suellencolangelo.forum.model.domain.Course
import com.suellencolangelo.forum.model.form.CourseForm
import com.suellencolangelo.forum.model.view.CourseView
import org.springframework.stereotype.Component

@Component
class CourseFormToDomainMapper : Mapper<CourseForm, Course> {

    override fun mapFrom(from: CourseForm) = Course(
        id = (1..100).random().toLong(),
        name = from.name,
        category = from.category
    )
}