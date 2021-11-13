package com.suellencolangelo.forum.mapper

import com.suellencolangelo.forum.model.domain.Course
import com.suellencolangelo.forum.model.view.CourseView
import org.springframework.stereotype.Component

@Component
class CourseToViewMapper : Mapper<Course, CourseView> {

    override fun mapFrom(from: Course) = CourseView(
        name = from.name,
        category = from.category
    )
}